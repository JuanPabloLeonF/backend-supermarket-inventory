package dev.juanleon.supermarket_inventory.files.infrastructure.configuration;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.files.domain.IFilesPersistence;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.files.domain.FilesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFileConfiguration {
    @Bean
    public IFilesService iFilesService(IFilesPersistence iFilesPersistence, AppConfigurationProperties appConfigurationProperties) {
        return new FilesUseCase(iFilesPersistence, appConfigurationProperties);
    }
}
