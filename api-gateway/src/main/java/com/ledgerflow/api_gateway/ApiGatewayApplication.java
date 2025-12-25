package com.ledgerflow.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public Object customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("user-service-route", r -> r.path("/users/**")
						.uri("http://user-service:8081")) // Direct Docker name
				.build();
	}
}
