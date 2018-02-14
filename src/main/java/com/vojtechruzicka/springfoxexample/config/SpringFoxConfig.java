package com.vojtechruzicka.springfoxexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "SpringFox Demo Application",
                "This application demonstrates documenting os Spring Boot app with Swagger using SpringFox.",
                "1.0.0",
                "TERMS OF SERVICE URL",
                new Contact("Vojtech Ruzicka", "http://www.vojtechruzicka.com", "vojtech.ruz@gmail.com"),
                "MIT License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

}
