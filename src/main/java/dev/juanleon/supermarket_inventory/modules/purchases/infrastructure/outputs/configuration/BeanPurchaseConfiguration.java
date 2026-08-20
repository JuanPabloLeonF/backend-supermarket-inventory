package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.persistence.get.IGetPurchasePersistence;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.persistence.post.IPostPurchasePersistence;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IEmployeeProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IProductProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IProviderProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.services.get.IGetPurchaseService;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.services.post.IPostPurchaseService;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.useCases.get.GetPurchaseUseCase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.useCases.post.PostPurchaseUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPurchaseConfiguration {

    @Bean
    public IPostPurchaseService iPostPurchaseService(
            IPostPurchasePersistence iPostPurchasePersistence,
            IEmployeeProviderPurchase iEmployeeProviderPurchase,
            IProviderProviderPurchase iProviderProviderPurchase,
            IProductProviderPurchase iProductProviderPurchase
    ) {
        return new PostPurchaseUseCases(
                iPostPurchasePersistence,
                iEmployeeProviderPurchase,
                iProviderProviderPurchase,
                iProductProviderPurchase
        );
    }

    @Bean
    public IGetPurchaseService iGetPurchaseService(
            IGetPurchasePersistence iGetPurchasePersistence,
            IProviderProviderPurchase iProviderProviderPurchase,
            IEmployeeProviderPurchase iEmployeeProviderPurchase
    ) {
        return new GetPurchaseUseCase(iGetPurchasePersistence, iProviderProviderPurchase, iEmployeeProviderPurchase);
    }
}
