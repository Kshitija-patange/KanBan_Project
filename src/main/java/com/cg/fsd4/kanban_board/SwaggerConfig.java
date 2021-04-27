package com.cg.fsd4.kanban_board;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2 

//http://localhost:8080/swagger-ui.html#/
public class SwaggerConfig
       {
		    @Bean
		    public Docket api() {
		        return new Docket(DocumentationType.SWAGGER_2)
		        		. apiInfo(metadata()).select().paths(regex("/api.*")).build();
			}

			@SuppressWarnings("deprecation")
			private ApiInfo metadata() {
			return new ApiInfoBuilder().title("Capgemini").description("API reference guide for developers").termsOfServiceUrl("https://www.cg.com/").build();	
			}
		}



