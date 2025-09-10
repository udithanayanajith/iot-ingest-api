package com.iot_ingest_api.uditha97.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IoT Ingest API")
                        .version("0.1.0")
                        .description("REST API for ingesting telemetry and publishing to Kafka — Uditha's prototype")
                        .contact(new Contact().name("Uditha").email("you@example.com"))
                        .license(new License().name("MIT")));
    }
}
