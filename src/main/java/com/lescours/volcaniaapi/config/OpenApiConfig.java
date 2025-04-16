package com.lescours.volcaniaapi.config;

import com.lescours.volcaniaapi.VolcaniaApiApplication;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "springdoc.api-docs.enabled", havingValue = "true", matchIfMissing = true)
public class OpenApiConfig {

    @Value("${build.version:unknown}")
    private String version;

    @Value("Running on ${deploy.environment:unknown} environment.")
    private String description;

    @Bean
    public OpenAPI apiDescription() {
        return new OpenAPI()
                .info(new Info()
                        .title("Volcania API")
                        .description(description)
                        .version(version)
                );
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api")
                .displayName("Volcania API")
                .packagesToScan(getPackageName("controller"))
                .build();
    }

    private String getPackageName(String sub) {
        return VolcaniaApiApplication.class.getPackage().getName() + "." + sub;
    }

}
