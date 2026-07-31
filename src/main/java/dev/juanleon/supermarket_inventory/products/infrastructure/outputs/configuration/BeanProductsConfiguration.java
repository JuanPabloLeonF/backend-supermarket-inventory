package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.products.domain.persistence.delete.IDeleteProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.persistence.get.IGetProductsPersistence;
import dev.juanleon.supermarket_inventory.products.domain.persistence.post.IPostProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.persistence.update.IUpdateProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.ports.IPortCategoriesProductsGet;
import dev.juanleon.supermarket_inventory.products.domain.ports.IPortFilesProducts;
import dev.juanleon.supermarket_inventory.products.domain.services.delete.IDeleteProductService;
import dev.juanleon.supermarket_inventory.products.domain.services.get.IGetProductsServices;
import dev.juanleon.supermarket_inventory.products.domain.services.post.IPostProductService;
import dev.juanleon.supermarket_inventory.products.domain.services.update.IUpdateProductService;
import dev.juanleon.supermarket_inventory.products.domain.useCases.delete.DeleteProductUseCase;
import dev.juanleon.supermarket_inventory.products.domain.useCases.get.GetProductsUseCases;
import dev.juanleon.supermarket_inventory.products.domain.useCases.post.PostProductUseCase;
import dev.juanleon.supermarket_inventory.products.domain.useCases.update.UpdateProductUseCase;
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
            IPortCategoriesProductsGet iPortCategoriesProductsGet,
            IPortFilesProducts iPortFilesProducts
    ) {
        return new PostProductUseCase(
                iPostProductPersistence,
                iPortCategoriesProductsGet,
                iPortFilesProducts
        );
    }

    @Bean
    public IUpdateProductService iUpdateProductService(
            IUpdateProductPersistence iUpdateProductPersistence,
            IGetCategoriesServices iGetCategoriesServices,
            IPortFilesProducts iPortFilesProducts
    ) {
        return new UpdateProductUseCase(
                iUpdateProductPersistence,
                iGetCategoriesServices,
                iPortFilesProducts
        );
    }

    @Bean
    public IDeleteProductService iDeleteProductService(IDeleteProductPersistence iDeleteProductPersistence) {
        return new DeleteProductUseCase(iDeleteProductPersistence);
    }
}
