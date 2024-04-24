package org.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("forward-to-wecommerce", r -> r
                        .path("/api/users/**")
                        .or().path("/api/products/**")
                        .uri("http://localhost:8081"))

                .route("forward-to-auth", r -> r
                        .path("/api/auth/**")
                        .uri("http://localhost:8005"))

                .route("forward-to-wepay", r -> r
                        .path("/api/payment/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
