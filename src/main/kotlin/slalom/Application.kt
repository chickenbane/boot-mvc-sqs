package slalom

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class Application {
    @Bean
    fun sqsSwagger(): Docket = Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .groupName("sqsops")
            .select()
            .paths(PathSelectors.regex("/sqs/.*"))
            .build()

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("SQS Operations")
                .description("Simple integration with Amazon SQS")
                .termsOfServiceUrl("https://github.com/joeyslalom/spring-booty")
                .contact(Contact("Joey T", "", ""))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/joeyslalom/spring-booty")
                .version("2.0")
                .build()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}