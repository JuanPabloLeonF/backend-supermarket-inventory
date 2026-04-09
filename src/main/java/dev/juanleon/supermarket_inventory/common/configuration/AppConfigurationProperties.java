package dev.juanleon.supermarket_inventory.common.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfigurationProperties {
    private String pathUploadImagesEmployees;
    private String pathUploadFilesPdfReports;
}
