package com.example.mongodbdemo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringmongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongodbApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration()
	{
		//Return a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiDetails());
	}
	
	
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
				"Mongo DB Operations API",
				"Sample API to do CRUD operations in Mongo DB",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Gagandeep Singh", "https://www.mongodb.com", "gagandeep0894@gmail.com"),
				"API License",
				"https://www.mongodb.com",
				Collections.emptyList());
	}

}
