package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.products.domain.persistence.get.IGetProductsPersistence;
import dev.juanleon.supermarket_inventory.products.domain.services.get.IGetProductsServices;
import dev.juanleon.supermarket_inventory.products.domain.useCases.get.GetProductsUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProductsConfiguration {

    @Bean
    public IGetProductsServices iGetProductsServices(IGetProductsPersistence iGetProductsPersistence) {
        return new GetProductsUseCases(iGetProductsPersistence);
    }
}
