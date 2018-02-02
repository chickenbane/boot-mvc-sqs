### Swagger Contract-First Workflow

1. Use the Swagger Editor to create an API: https://editor.swagger.io
2. Add the yaml file to this project
3. This module will build the API and Model classes for your project

* Uses: https://github.com/swagger-api/swagger-codegen
* Gradle Plugin: https://github.com/int128/gradle-swagger-generator-plugin
    * To generate: `./gradlew :swagger:generateSwaggerCode`
    * To build: `./gradlew :swagger:build`