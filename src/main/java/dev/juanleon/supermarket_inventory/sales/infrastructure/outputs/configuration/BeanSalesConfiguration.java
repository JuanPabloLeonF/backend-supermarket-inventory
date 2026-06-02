package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.sales.domain.persistence.get.IGetSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.domain.services.get.IGetSalesServices;
import dev.juanleon.supermarket_inventory.sales.domain.useCases.get.GetSalesUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanSalesConfiguration {

    @Bean
    public IGetSalesServices iGetSalesServices(IGetSalesPersistence iGetSalesPersistence) {
        return new GetSalesUseCases(iGetSalesPersistence);
    }
}
