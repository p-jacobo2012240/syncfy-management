## About the syncfy-management

Syncfy-management contains all features of handling events by apache kafka, actions and entities 
required for sync files, and realms config for OAuth 

## Features

- Cloud Native infrastructure
- Event handling engine
- OAuth2 protection
- Performant transaction system

## DB Architecture
![DB-Architecture](https://raw.githubusercontent.com/p-jacobo2012240/syncfy-management/master/src/main/resources/diagrams/ERD-Syncfy-DB-reboot-2k24.png)

## Requirements

- Java 17 (OpenJDK)
- Maven
- Keycloack (OpenJDK Service) 
- Apache kafka (^kafka_2.12-2.7.2)
- Apache ZooKeeper (^kafka_2.12-2.7.2)
- PostgreSQL


Compile for dev-enviroment:
```sh
mvn clean install
```



