package dev.juanleon.supermarket_inventory.files.infrastructure.configuration;

import dev.juanleon.supermarket_inventory.files.domain.IFilesPersistence;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.files.domain.FilesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFileConfiguration {
    @Bean
    public IFilesService iFilesService(IFilesPersistence iFilesPersistence) {
        return new FilesUseCase(iFilesPersistence);
    }
}
