package com.epam.ordering.item.api.swagger;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger configurations 
 * 
 * @author vikashkumar
 *
 */
@Configuration
@EnableCaching
@EnableSwagger2
public class AppConfig {
	
	/**
	 * Method required for Swagger implementation
	 * @return
	 */
	@Bean
	public Docket orderItemApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(orderApiInfo()).groupName("order-item-service")
				.tags(
				    new Tag("Order-Item", "API for Add Order Items")
					)
					.select().apis(RequestHandlerSelectors.basePackage("com.epam.ordering.item.api"))
					.paths(PathSelectors.ant("/orderitem/**")).build();

	}

	/**
	 * Method required for Swagger implementation
	 * 
	 * @return {@link ApiInfo}
	 */
	private ApiInfo orderApiInfo() {
		return new ApiInfoBuilder().title("ORDER ITEM SERVICE").description("Order Item Service API")
				.version("1.0").build();
	}


}