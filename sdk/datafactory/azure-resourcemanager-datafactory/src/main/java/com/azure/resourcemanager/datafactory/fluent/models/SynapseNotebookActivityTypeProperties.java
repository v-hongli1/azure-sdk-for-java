// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.models.BigDataPoolParametrizationReference;
import com.azure.resourcemanager.datafactory.models.ConfigurationType;
import com.azure.resourcemanager.datafactory.models.NotebookParameter;
import com.azure.resourcemanager.datafactory.models.SparkConfigurationParametrizationReference;
import com.azure.resourcemanager.datafactory.models.SynapseNotebookReference;
import java.io.IOException;
import java.util.Map;

/**
 * Execute Synapse notebook activity properties.
 */
@Fluent
public final class SynapseNotebookActivityTypeProperties
    implements JsonSerializable<SynapseNotebookActivityTypeProperties> {
    /*
     * Synapse notebook reference.
     */
    private SynapseNotebookReference notebook;

    /*
     * The name of the big data pool which will be used to execute the notebook.
     */
    private BigDataPoolParametrizationReference sparkPool;

    /*
     * Notebook parameters.
     */
    private Map<String, NotebookParameter> parameters;

    /*
     * Number of core and memory to be used for executors allocated in the specified Spark pool for the session, which
     * will be used for overriding 'executorCores' and 'executorMemory' of the notebook you provide. Type: string (or
     * Expression with resultType string).
     */
    private Object executorSize;

    /*
     * Spark configuration properties, which will override the 'conf' of the notebook you provide.
     */
    private Object conf;

    /*
     * Number of core and memory to be used for driver allocated in the specified Spark pool for the session, which will
     * be used for overriding 'driverCores' and 'driverMemory' of the notebook you provide. Type: string (or Expression
     * with resultType string).
     */
    private Object driverSize;

    /*
     * Number of executors to launch for this session, which will override the 'numExecutors' of the notebook you
     * provide. Type: integer (or Expression with resultType integer).
     */
    private Object numExecutors;

    /*
     * The type of the spark config.
     */
    private ConfigurationType configurationType;

    /*
     * The spark configuration of the spark job.
     */
    private SparkConfigurationParametrizationReference targetSparkConfiguration;

    /*
     * Spark configuration property.
     */
    private Map<String, Object> sparkConfig;

    /**
     * Creates an instance of SynapseNotebookActivityTypeProperties class.
     */
    public SynapseNotebookActivityTypeProperties() {
    }

    /**
     * Get the notebook property: Synapse notebook reference.
     * 
     * @return the notebook value.
     */
    public SynapseNotebookReference notebook() {
        return this.notebook;
    }

    /**
     * Set the notebook property: Synapse notebook reference.
     * 
     * @param notebook the notebook value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withNotebook(SynapseNotebookReference notebook) {
        this.notebook = notebook;
        return this;
    }

    /**
     * Get the sparkPool property: The name of the big data pool which will be used to execute the notebook.
     * 
     * @return the sparkPool value.
     */
    public BigDataPoolParametrizationReference sparkPool() {
        return this.sparkPool;
    }

    /**
     * Set the sparkPool property: The name of the big data pool which will be used to execute the notebook.
     * 
     * @param sparkPool the sparkPool value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withSparkPool(BigDataPoolParametrizationReference sparkPool) {
        this.sparkPool = sparkPool;
        return this;
    }

    /**
     * Get the parameters property: Notebook parameters.
     * 
     * @return the parameters value.
     */
    public Map<String, NotebookParameter> parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: Notebook parameters.
     * 
     * @param parameters the parameters value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withParameters(Map<String, NotebookParameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the executorSize property: Number of core and memory to be used for executors allocated in the specified
     * Spark pool for the session, which will be used for overriding 'executorCores' and 'executorMemory' of the
     * notebook you provide. Type: string (or Expression with resultType string).
     * 
     * @return the executorSize value.
     */
    public Object executorSize() {
        return this.executorSize;
    }

    /**
     * Set the executorSize property: Number of core and memory to be used for executors allocated in the specified
     * Spark pool for the session, which will be used for overriding 'executorCores' and 'executorMemory' of the
     * notebook you provide. Type: string (or Expression with resultType string).
     * 
     * @param executorSize the executorSize value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withExecutorSize(Object executorSize) {
        this.executorSize = executorSize;
        return this;
    }

    /**
     * Get the conf property: Spark configuration properties, which will override the 'conf' of the notebook you
     * provide.
     * 
     * @return the conf value.
     */
    public Object conf() {
        return this.conf;
    }

    /**
     * Set the conf property: Spark configuration properties, which will override the 'conf' of the notebook you
     * provide.
     * 
     * @param conf the conf value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withConf(Object conf) {
        this.conf = conf;
        return this;
    }

    /**
     * Get the driverSize property: Number of core and memory to be used for driver allocated in the specified Spark
     * pool for the session, which will be used for overriding 'driverCores' and 'driverMemory' of the notebook you
     * provide. Type: string (or Expression with resultType string).
     * 
     * @return the driverSize value.
     */
    public Object driverSize() {
        return this.driverSize;
    }

    /**
     * Set the driverSize property: Number of core and memory to be used for driver allocated in the specified Spark
     * pool for the session, which will be used for overriding 'driverCores' and 'driverMemory' of the notebook you
     * provide. Type: string (or Expression with resultType string).
     * 
     * @param driverSize the driverSize value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withDriverSize(Object driverSize) {
        this.driverSize = driverSize;
        return this;
    }

    /**
     * Get the numExecutors property: Number of executors to launch for this session, which will override the
     * 'numExecutors' of the notebook you provide. Type: integer (or Expression with resultType integer).
     * 
     * @return the numExecutors value.
     */
    public Object numExecutors() {
        return this.numExecutors;
    }

    /**
     * Set the numExecutors property: Number of executors to launch for this session, which will override the
     * 'numExecutors' of the notebook you provide. Type: integer (or Expression with resultType integer).
     * 
     * @param numExecutors the numExecutors value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withNumExecutors(Object numExecutors) {
        this.numExecutors = numExecutors;
        return this;
    }

    /**
     * Get the configurationType property: The type of the spark config.
     * 
     * @return the configurationType value.
     */
    public ConfigurationType configurationType() {
        return this.configurationType;
    }

    /**
     * Set the configurationType property: The type of the spark config.
     * 
     * @param configurationType the configurationType value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withConfigurationType(ConfigurationType configurationType) {
        this.configurationType = configurationType;
        return this;
    }

    /**
     * Get the targetSparkConfiguration property: The spark configuration of the spark job.
     * 
     * @return the targetSparkConfiguration value.
     */
    public SparkConfigurationParametrizationReference targetSparkConfiguration() {
        return this.targetSparkConfiguration;
    }

    /**
     * Set the targetSparkConfiguration property: The spark configuration of the spark job.
     * 
     * @param targetSparkConfiguration the targetSparkConfiguration value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties
        withTargetSparkConfiguration(SparkConfigurationParametrizationReference targetSparkConfiguration) {
        this.targetSparkConfiguration = targetSparkConfiguration;
        return this;
    }

    /**
     * Get the sparkConfig property: Spark configuration property.
     * 
     * @return the sparkConfig value.
     */
    public Map<String, Object> sparkConfig() {
        return this.sparkConfig;
    }

    /**
     * Set the sparkConfig property: Spark configuration property.
     * 
     * @param sparkConfig the sparkConfig value to set.
     * @return the SynapseNotebookActivityTypeProperties object itself.
     */
    public SynapseNotebookActivityTypeProperties withSparkConfig(Map<String, Object> sparkConfig) {
        this.sparkConfig = sparkConfig;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (notebook() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property notebook in model SynapseNotebookActivityTypeProperties"));
        } else {
            notebook().validate();
        }
        if (sparkPool() != null) {
            sparkPool().validate();
        }
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
        if (targetSparkConfiguration() != null) {
            targetSparkConfiguration().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SynapseNotebookActivityTypeProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("notebook", this.notebook);
        jsonWriter.writeJsonField("sparkPool", this.sparkPool);
        jsonWriter.writeMapField("parameters", this.parameters, (writer, element) -> writer.writeJson(element));
        if (this.executorSize != null) {
            jsonWriter.writeUntypedField("executorSize", this.executorSize);
        }
        if (this.conf != null) {
            jsonWriter.writeUntypedField("conf", this.conf);
        }
        if (this.driverSize != null) {
            jsonWriter.writeUntypedField("driverSize", this.driverSize);
        }
        if (this.numExecutors != null) {
            jsonWriter.writeUntypedField("numExecutors", this.numExecutors);
        }
        jsonWriter.writeStringField("configurationType",
            this.configurationType == null ? null : this.configurationType.toString());
        jsonWriter.writeJsonField("targetSparkConfiguration", this.targetSparkConfiguration);
        jsonWriter.writeMapField("sparkConfig", this.sparkConfig, (writer, element) -> writer.writeUntyped(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SynapseNotebookActivityTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SynapseNotebookActivityTypeProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SynapseNotebookActivityTypeProperties.
     */
    public static SynapseNotebookActivityTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SynapseNotebookActivityTypeProperties deserializedSynapseNotebookActivityTypeProperties
                = new SynapseNotebookActivityTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("notebook".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.notebook
                        = SynapseNotebookReference.fromJson(reader);
                } else if ("sparkPool".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.sparkPool
                        = BigDataPoolParametrizationReference.fromJson(reader);
                } else if ("parameters".equals(fieldName)) {
                    Map<String, NotebookParameter> parameters
                        = reader.readMap(reader1 -> NotebookParameter.fromJson(reader1));
                    deserializedSynapseNotebookActivityTypeProperties.parameters = parameters;
                } else if ("executorSize".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.executorSize = reader.readUntyped();
                } else if ("conf".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.conf = reader.readUntyped();
                } else if ("driverSize".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.driverSize = reader.readUntyped();
                } else if ("numExecutors".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.numExecutors = reader.readUntyped();
                } else if ("configurationType".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.configurationType
                        = ConfigurationType.fromString(reader.getString());
                } else if ("targetSparkConfiguration".equals(fieldName)) {
                    deserializedSynapseNotebookActivityTypeProperties.targetSparkConfiguration
                        = SparkConfigurationParametrizationReference.fromJson(reader);
                } else if ("sparkConfig".equals(fieldName)) {
                    Map<String, Object> sparkConfig = reader.readMap(reader1 -> reader1.readUntyped());
                    deserializedSynapseNotebookActivityTypeProperties.sparkConfig = sparkConfig;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSynapseNotebookActivityTypeProperties;
        });
    }
}
