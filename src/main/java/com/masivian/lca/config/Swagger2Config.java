package com.masivian.lca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration for Swagger V2
 * 
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
    /**
     * Bean to configure swagger
     * 
     * @return the swagger configuration
     */
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.masivian.lca"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiEndPointsInfo());
        }
    
    /**
     * Info of API for swagger configuration
     * 
     * @return API details
     */
    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder().title("Masivian Spring Boot REST API")
            .description("Lowest Common Ancestor REST API")
            .contact(new Contact("Hernan Carreno", "www.masivian.com", "hernan.laguado@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();

    }
}