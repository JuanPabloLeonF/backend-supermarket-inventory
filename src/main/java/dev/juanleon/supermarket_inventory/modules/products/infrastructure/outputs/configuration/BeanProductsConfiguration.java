package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.modules.products.domain.persistence.delete.IDeleteProductPersistence;
import dev.juanleon.supermarket_inventory.modules.products.domain.persistence.get.IGetProductsPersistence;
import dev.juanleon.supermarket_inventory.modules.products.domain.persistence.post.IPostProductPersistence;
import dev.juanleon.supermarket_inventory.modules.products.domain.persistence.update.IUpdateProductPersistence;
import dev.juanleon.supermarket_inventory.modules.products.domain.ports.ICategoriesProviderProduct;
import dev.juanleon.supermarket_inventory.modules.products.domain.ports.IFilesProviderProduct;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.delete.IDeleteProductService;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.get.IGetProductsServices;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.post.IPostProductService;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.update.IUpdateProductService;
import dev.juanleon.supermarket_inventory.modules.products.domain.useCases.delete.DeleteProductUseCase;
import dev.juanleon.supermarket_inventory.modules.products.domain.useCases.get.GetProductsUseCases;
import dev.juanleon.supermarket_inventory.modules.products.domain.useCases.post.PostProductUseCase;
import dev.juanleon.supermarket_inventory.modules.products.domain.useCases.update.UpdateProductUseCase;
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
            ICategoriesProviderProduct iCategoriesProviderProduct,
            IFilesProviderProduct iFilesProviderProduct
    ) {
        return new PostProductUseCase(
                iPostProductPersistence,
                iCategoriesProviderProduct,
                iFilesProviderProduct
        );
    }

    @Bean
    public IUpdateProductService iUpdateProductService(
            IUpdateProductPersistence iUpdateProductPersistence,
            IGetCategoriesServices iGetCategoriesServices,
            IFilesProviderProduct iFilesProviderProduct
    ) {
        return new UpdateProductUseCase(
                iUpdateProductPersistence,
                iGetCategoriesServices,
                iFilesProviderProduct
        );
    }

    @Bean
    public IDeleteProductService iDeleteProductService(IDeleteProductPersistence iDeleteProductPersistence) {
        return new DeleteProductUseCase(iDeleteProductPersistence);
    }
}
