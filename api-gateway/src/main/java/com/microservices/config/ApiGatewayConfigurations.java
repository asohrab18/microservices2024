package com.microservices.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfigurations {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder rlBuilder) {
		return rlBuilder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("myHeaderName", "myHeaderValue")
								.addRequestParameter("myParam", "myParamValue"))
						.uri("http://httpbin.org:80"))

				.route(p -> p.path("/exchange-currency/**").uri("lb://exchange-currency-service"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
				.route(p -> p.path("/currency-conversion-new/**")
						.filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)",
								"/currency-conversion/${segment}"))
						.uri("lb://currency-conversion-service"))
				.build();
		
		/**Here, "lb://exchange-currency-service" means "lb:Eureka-Registered-Service-Name"*/
	}
}
