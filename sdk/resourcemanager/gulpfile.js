var path = require("path");
var gulp = require("gulp");
var args = require("yargs").argv;
var colors = require("colors");
var execa = require("execa");
var pAll = require("p-all");
var os = require("os");
var fs = require("fs");
var shell = require("gulp-shell");
var ghPages = require("gulp-gh-pages");
var argv = require("yargs").argv;
var gulpif = require("gulp-if");
var exec = require("child_process").exec;

const mappings = require("./api-specs.json");
const defaultSpecRoot = "https://raw.githubusercontent.com/Azure/azure-rest-api-specs/main";

async function defaultInfo() {
    console.log(
        "Usage: gulp codegen " +
            "[--spec-root <swagger specs root>] " +
            "[--projects <project names>] " +
            "[--autorest <autorest info>] " +
            "[--autorest-java <autorest.java info>] " +
            "[--debugger] " +
            "[--parallel <number>] " +
            "[--autorest-args <AutoRest arguments>] " +
            "[--apispecs-args <ApiSpecs arguments>]\n"
    );

    console.log("--spec-root");
    console.log(`\tRoot location of Swagger API specs, default value is "${defaultSpecRoot}"`);

    console.log("--projects");
    console.log("\tComma separated projects to regenerate, default is all. List of available project names:");
    Object.keys(mappings).forEach(function (i) {
        console.log("\t" + i.magenta);
    });

    console.log("--autorest");
    console.log(
        "\tThe version of AutoRest Core. E.g. 3.9.6, or the location of AutoRest repo, e.g. E:\\repo\\autorest"
    );

    console.log("--autorest-java");
    console.log("\tPath to an autorest.java generator to pass as a --use argument to AutoRest.");
    console.log(
        "\tUsually you'll only need to provide this and not a --autorest argument in order to work on Java code generation."
    );
    console.log("\tSee https://github.com/Azure/autorest/blob/main/docs/developer/writing-an-extension.md");

    console.log("--debug");
    console.log("\tFlag that allows you to attach a debugger to the autorest.java generator.");

    console.log("--parallel");
    console.log("\tSpecifies the maximum number of projects to generate in parallel.");
    console.log("\tDefaults to the number of logical CPUs on the system. (On this system, " + os.cpus().length + ")");

    console.log("--autorest-args");
    console.log("\tPasses additional argument to AutoRest generator");

    console.log("--apispecs-args");
    console.log("\tPasses additional argument to Api Specs");
}

const maxParallelism = parseInt(args["parallel"], 10) || os.cpus().length;
var projects = args["projects"];
var autoRestVersion = "3.9.7"; // default
if (args["autorest"] !== undefined) {
    autoRestVersion = args["autorest"];
}
var autoRestJava = "@autorest/java@latest"; // default
if (args["autorest-java"] !== undefined) {
    autoRestJava = args["autorest-java"];
}
var debug = args["debugger"];
var autoRestArgs = args["autorest-args"] || "";
var autoRestExe;

async function generate(cb) {
    if (autoRestVersion.match(/[0-9]+\.[0-9]+\.[0-9]+.*/) || autoRestVersion == "latest") {
        autoRestExe = "autorest --version=" + autoRestVersion;
        handleInput(projects, cb);
    } else {
        autoRestExe = "node " + path.join(autoRestVersion, "src/autorest-core/dist/app.js");
        handleInput(projects, cb);
    }
}

function handleInput(projects, cb) {
    console.info(`Generating up to ${maxParallelism} projects in parallel..`);
    if (projects === undefined) {
        const actions = Object.keys(mappings).map((proj) => {
            return () => codegen(proj, cb);
        });
        pAll(actions, { concurrency: maxParallelism });
    } else {
        const actions = projects.split(",").map((proj) => {
            return () => {
                proj = proj.replace(/\ /g, "");
                if (mappings[proj] === undefined) {
                    console.error('Invalid project name "' + proj + '"!');
                    process.exit(1);
                }
                return codegen(proj, cb);
            };
        });
        pAll(actions, { concurrency: maxParallelism });
    }
}

function codegen(project, cb) {
    packagePath = mappings[project].package.replace(/\./g, "/");

    if (!args["preserve"]) {
        const sourcesToDelete = path.join(mappings[project].dir, "/src/main/java/", packagePath);

        deleteFolderRecursive(sourcesToDelete);

        generatedSamplesTarget = path.join("azure-resourcemanager/src/samples/java/", packagePath, "generated");
        deleteFolderRecursive(generatedSamplesTarget);
    }

    // path.join won't work if specRoot is a URL
    let projectSpecRoot = args["spec-root"] || mappings[project].spec || defaultSpecRoot;
    const readmeFile = projectSpecRoot + "/" + mappings[project].source;

    console.log('Generating "' + project + '" from spec file ' + readmeFile);
    var generator = "--fluent";
    if (mappings[project].fluent !== null && mappings[project].fluent === false) {
        generator = "";
    }

    const generatorPath = autoRestJava
        ? autoRestJava.startsWith("@autorest/java")
            ? `--use=${autoRestJava} `
            : `--use=${path.resolve(autoRestJava)} `
        : "";

    const regenManager = args["regenerate-manager"] ? " --regenerate-manager " : "";

    const outDir = path.resolve(mappings[project].dir);
    cmd =
        autoRestExe +
        " " +
        readmeFile +
        " --java " +
        " --azure-arm " +
        " --modelerfour.additional-checks=false " +
        " --generate-samples " +
        generator +
        ` --java.namespace=${mappings[project].package} ` +
        ` --java.output-folder=${outDir} ` +
        ` --java.license-header=MICROSOFT_MIT_SMALL ` +
        generatorPath +
        regenManager +
        autoRestArgs;

    if (args["apispecs-args"]) {
        cmd += " " +  args["apispecs-args"];
    }

    if (debug) {
        cmd += " --java.debugger";
    }

    console.log("Command: " + cmd);
    autorest_result = execa.sync(cmd, [], { shell: true, stdio: "inherit" });

    // move generated samples to azure-resourcemanager
    generatedSamplesSource = path.join(mappings[project].dir, "/src/samples/java/", packagePath, "generated");
    generatedSamplesTarget = path.join("azure-resourcemanager/src/samples/java/", packagePath);

    copyFolderRecursiveSync(generatedSamplesSource, generatedSamplesTarget);
    deleteFolderRecursive(generatedSamplesSource);

    return autorest_result;
}

function deleteFolderRecursive(path) {
    var header = "Code generated by Microsoft (R) AutoRest Code Generator";
    if (fs.existsSync(path)) {
        fs.readdirSync(path).forEach(function (file, index) {
            var curPath = path + "/" + file;
            if (fs.lstatSync(curPath).isDirectory()) {
                // recurse
                deleteFolderRecursive(curPath);
            } else {
                // delete file
                var content = fs.readFileSync(curPath).toString("utf8");
                if (content.indexOf(header) > -1) {
                    fs.unlinkSync(curPath);
                }
            }
        });
    }
}

function copyFileSync(source, target) {
    var targetFile = target;

    // If target is a directory, a new file with the same name will be created
    if (fs.existsSync(target)) {
        if (fs.lstatSync(target).isDirectory()) {
            targetFile = path.join(target, path.basename(source));
        }
    }

    fs.writeFileSync(targetFile, fs.readFileSync(source));
}

function copyFolderRecursiveSync(source, target) {
    if (fs.existsSync(source)) {
        var files = [];

        // Check if folder needs to be created or integrated
        var targetFolder = path.join(target, path.basename(source));
        if (!fs.existsSync(targetFolder)) {
            fs.mkdirSync(targetFolder, { recursive: true });
        }

        // Copy
        if (fs.lstatSync(source).isDirectory()) {
            files = fs.readdirSync(source);
            files.forEach(function (file) {
                var curSource = path.join(source, file);
                if (fs.lstatSync(curSource).isDirectory()) {
                    copyFolderRecursiveSync(curSource, targetFolder);
                } else {
                    copyFileSync(curSource, targetFolder);
                }
            });
        }
    }
}

async function prepareBuild() {
    return shell.task("mvn package javadoc:aggregate -DskipTests -q");
}

async function prepareStage() {
    return gulp.src("./target/site/apidocs/**/*").pipe(gulp.dest("./dist"));
}

async function preparePublish() {
    var options = {};
    if (process.env.GH_TOKEN) {
        options.remoteUrl = "https://" + process.env.GH_TOKEN + "@github.com/azure/azure-libraries-for-java.git";
    }
    return gulp.src("./dist/**/*").pipe(gulpif(!argv.dryrun, ghPages(options)));
}

const build = prepareBuild;
const stage = gulp.series(build, prepareStage);
const publish = gulp.series(stage, preparePublish);

//exports task
exports.default = defaultInfo;
exports.codegen = generate;
exports.build = build;
exports.stage = stage;
exports.publish = publish;
