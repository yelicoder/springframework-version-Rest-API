package com.aiconsulting.swagger4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class ApplicationSwaggerConfig {

    @Bean
    public Docket employeeApi1() {
        return
                new Docket(DocumentationType.SWAGGER_2)
                        .groupName("employee-api-v1")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo("v1"));
    }

    @Bean
    public Docket employeeApi2() {
        return
                new Docket(DocumentationType.SWAGGER_2)
                        .groupName("employee-api-v2")
                        .select()
                        .apis(RequestHandlerSelectors.any())
                        .paths(PathSelectors.ant("/v2/**"))
                        .build()
                        .apiInfo(getApiInfo("v2"));
    }

    private ApiInfo getApiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Employee API")
                .version(version)
                .description("API to manage employees")
                .contact(new Contact("Ye Li", "http://google.com", "test@gmail.com"))
                .license("Apache License Version 2.0")
                .build();
    }
}
