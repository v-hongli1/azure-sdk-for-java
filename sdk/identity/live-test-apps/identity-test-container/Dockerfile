# ------------------------------------
# Copyright (c) Microsoft Corporation.
# Licensed under the MIT License.
# ------------------------------------
# docker can't tell when the repo has changed and will therefore cache this layer

# internal users should provide MCR registry to build via 'docker build . --build-arg REGISTRY="mcr.microsoft.com/mirror/docker/library/"'
# public OSS users should simply leave this argument blank or ignore its presence entirely
ARG REGISTRY=""

FROM ${REGISTRY}alpine:3.19 as repo
RUN apk --no-cache add git
RUN git clone https://github.com/Azure/azure-sdk-for-java --single-branch --depth 1 /azure-sdk-for-java


FROM maven:3-jdk-8
COPY --from=clone /azure-sdk-for-java /azure-sdk-for-java
WORKDIR /azure-sdk-for-java

RUN mvn clean install -Dgpg.skip -DskipTests -f eng/code-quality-reports/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -f common/perf-test-core/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -Dmaven.javadoc.skip=true -f sdk/core/azure-core/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -Dmaven.javadoc.skip=true -f sdk/core/azure-core-test/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -Dmaven.javadoc.skip=true -f sdk/core/azure-core-http-netty/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -Dmaven.javadoc.skip=true -f sdk/identity/azure-identity/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -Dmaven.javadoc.skip=true -f sdk/keyvault/azure-security-keyvault-secrets/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -Dmaven.javadoc.skip=true -f sdk/keyvault/azure-security-keyvault-keys/pom.xml
RUN mvn clean install -Dgpg.skip -DskipTests -Dmaven.javadoc.skip=true -f sdk/keyvault/azure-security-keyvault-certificates/pom.xml

CMD [ "sleep", "infinity" ]
