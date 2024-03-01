package in.ac.iitmandi.SmartParkingBackend.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("in.ac.iitmandi.SmartParkingBackend.controller"))
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(metaData())
                .protocols(new HashSet<>(Collections.singletonList("http")));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Rest Service for Smart Parking")
                .description("Rest Service for Smart Parking using Spring Boot")
                .version("2.0")
                .contact(new Contact("Ashutosh Litoriya", "url", "ashutosh.litoriya1@gmail.com")).build();
    }
}
