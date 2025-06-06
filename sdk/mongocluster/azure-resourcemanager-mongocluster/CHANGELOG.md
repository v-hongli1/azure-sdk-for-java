# Release History

## 1.1.0-beta.1 (2025-06-04)

- Azure Resource Manager Mongo Cluster client library for Java. This package contains Microsoft Azure SDK for Mongo Cluster Management SDK. The Microsoft Azure management API provides create, read, update, and delete functionality for Azure Cosmos DB for MongoDB vCore resources including clusters and firewall rules. Package api-version 2025-04-01-preview. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

* `implementation.models.UserListResult` was added

* `models.DatabaseRole` was added

* `models.IdentityProvider` was added

* `models.User` was added

* `models.EntraIdentityProviderProperties` was added

* `models.User$UpdateStages` was added

* `models.StorageType` was added

* `models.UserProperties` was added

* `models.EntraPrincipalType` was added

* `models.EntraIdentityProvider` was added

* `models.DataApiMode` was added

* `models.User$DefinitionStages` was added

* `models.UserRole` was added

* `models.User$Definition` was added

* `models.AuthenticationMode` was added

* `models.Users` was added

* `models.IdentityProviderType` was added

* `models.AuthConfigProperties` was added

* `models.DataApiProperties` was added

* `models.User$Update` was added

#### `models.MongoClusterProperties` was modified

* `authConfig()` was added
* `withDataApi(models.DataApiProperties)` was added
* `withAuthConfig(models.AuthConfigProperties)` was added
* `dataApi()` was added

#### `models.StorageProperties` was modified

* `type()` was added
* `withType(models.StorageType)` was added
* `withThroughput(java.lang.Long)` was added
* `iops()` was added
* `withIops(java.lang.Long)` was added
* `throughput()` was added

#### `MongoClusterManager` was modified

* `users()` was added

#### `models.MongoClusterUpdateProperties` was modified

* `dataApi()` was added
* `withDataApi(models.DataApiProperties)` was added
* `authConfig()` was added
* `withAuthConfig(models.AuthConfigProperties)` was added

## 1.0.0 (2024-09-25)

- Azure Resource Manager Mongo Cluster client library for Java. This package contains Microsoft Azure SDK for Mongo Cluster Management SDK. The Microsoft Azure management API provides create, read, update, and delete functionality for Azure Cosmos DB for MongoDB vCore resources including clusters and firewall rules. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Breaking Changes

* `models.NodeGroupSpec` was removed

* `models.NodeKind` was removed

#### `MongoClusterManager` was modified

* `fluent.DocumentDBClient serviceClient()` -> `fluent.MongoClusterManagementClient serviceClient()`

#### `models.MongoClusterProperties` was modified

* `earliestRestoreTime()` was removed
* `withAdministratorLoginPassword(java.lang.String)` was removed
* `withNodeGroupSpecs(java.util.List)` was removed
* `administratorLogin()` was removed
* `nodeGroupSpecs()` was removed
* `withAdministratorLogin(java.lang.String)` was removed
* `administratorLoginPassword()` was removed

#### `models.MongoClusterUpdateProperties` was modified

* `administratorLogin()` was removed
* `administratorLoginPassword()` was removed
* `nodeGroupSpecs()` was removed
* `withNodeGroupSpecs(java.util.List)` was removed
* `withAdministratorLoginPassword(java.lang.String)` was removed
* `withAdministratorLogin(java.lang.String)` was removed

### Features Added

* `models.BackupProperties` was added

* `models.HighAvailabilityMode` was added

* `models.StorageProperties` was added

* `models.ShardingProperties` was added

* `models.AdministratorProperties` was added

* `models.ComputeProperties` was added

* `models.HighAvailabilityProperties` was added

#### `models.MongoClusterProperties` was modified

* `highAvailability()` was added
* `withCompute(models.ComputeProperties)` was added
* `withAdministrator(models.AdministratorProperties)` was added
* `withHighAvailability(models.HighAvailabilityProperties)` was added
* `storage()` was added
* `compute()` was added
* `sharding()` was added
* `administrator()` was added
* `withSharding(models.ShardingProperties)` was added
* `withStorage(models.StorageProperties)` was added
* `withBackup(models.BackupProperties)` was added
* `backup()` was added

#### `models.ConnectionString` was modified

* `name()` was added

#### `models.MongoClusterUpdateProperties` was modified

* `backup()` was added
* `withCompute(models.ComputeProperties)` was added
* `compute()` was added
* `administrator()` was added
* `withHighAvailability(models.HighAvailabilityProperties)` was added
* `highAvailability()` was added
* `withStorage(models.StorageProperties)` was added
* `withBackup(models.BackupProperties)` was added
* `sharding()` was added
* `storage()` was added
* `withAdministrator(models.AdministratorProperties)` was added
* `withSharding(models.ShardingProperties)` was added

## 1.0.0-beta.2 (2024-09-24)

- Azure Resource Manager Mongo Cluster client library for Java. This package contains Microsoft Azure SDK for Mongo Cluster Management SDK. The Microsoft Azure management API provides create, read, update, and delete functionality for Azure Cosmos DB for MongoDB vCore resources including clusters and firewall rules. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

* `models.PromoteMode` was added

* `models.PromoteOption` was added

* `models.Replicas` was added

* `models.ReplicationProperties` was added

* `implementation.models.ReplicaListResult` was added

* `models.ReplicationRole` was added

* `models.MongoClusterReplicaParameters` was added

* `models.ReplicationState` was added

* `models.Replica` was added

* `models.PromoteReplicaRequest` was added

* `models.PreviewFeature` was added

#### `models.MongoClusters` was modified

* `promote(java.lang.String,java.lang.String,models.PromoteReplicaRequest)` was added
* `promote(java.lang.String,java.lang.String,models.PromoteReplicaRequest,com.azure.core.util.Context)` was added

#### `MongoClusterManager` was modified

* `replicas()` was added

#### `models.MongoClusterProperties` was modified

* `withReplicaParameters(models.MongoClusterReplicaParameters)` was added
* `replicaParameters()` was added
* `replica()` was added
* `withPreviewFeatures(java.util.List)` was added
* `infrastructureVersion()` was added
* `previewFeatures()` was added

#### `models.MongoCluster` was modified

* `promote(models.PromoteReplicaRequest)` was added
* `promote(models.PromoteReplicaRequest,com.azure.core.util.Context)` was added

#### `models.MongoClusterUpdateProperties` was modified

* `previewFeatures()` was added
* `withPreviewFeatures(java.util.List)` was added

## 1.0.0-beta.1 (2024-07-01)

- Azure Resource Manager Mongo Cluster client library for Java. This package contains Microsoft Azure SDK for Mongo Cluster Management SDK. The Microsoft Azure management API provides create, read, update, and delete functionality for Azure Cosmos DB for MongoDB vCore resources including clusters and firewall rules. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

- Initial release for the azure-resourcemanager-mongocluster Java SDK. 
