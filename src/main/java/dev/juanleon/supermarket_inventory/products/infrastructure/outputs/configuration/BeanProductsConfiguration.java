package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.products.domain.persistence.get.IGetProductsPersistence;
import dev.juanleon.supermarket_inventory.products.domain.persistence.post.IPostProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.services.get.IGetProductsServices;
import dev.juanleon.supermarket_inventory.products.domain.services.post.IPostProductService;
import dev.juanleon.supermarket_inventory.products.domain.useCases.get.GetProductsUseCases;
import dev.juanleon.supermarket_inventory.products.domain.useCases.post.PostProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProductsConfiguration {

    @Bean
    public IGetProductsServices iGetProductsServices(IGetProductsPersistence iGetProductsPersistence) {
        return new GetProductsUseCases(iGetProductsPersistence);
    }

    @Bean
    public IPostProductService iPostProductService(
            IPostProductPersistence iPostProductPersistence,
            IGetCategoriesServices iGetCategoriesServices
    ) {
        return new PostProductUseCase(iPostProductPersistence, iGetCategoriesServices);
    }
}
