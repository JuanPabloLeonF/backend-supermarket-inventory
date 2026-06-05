package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.sales.domain.persistence.get.IGetSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.domain.persistence.post.IPostSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.domain.services.get.IGetSalesServices;
import dev.juanleon.supermarket_inventory.sales.domain.services.post.IPostSalesServices;
import dev.juanleon.supermarket_inventory.sales.domain.useCases.get.GetSalesUseCases;
import dev.juanleon.supermarket_inventory.sales.domain.useCases.post.PostSalesUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanSalesConfiguration {

    @Bean
    public IGetSalesServices iGetSalesServices(IGetSalesPersistence iGetSalesPersistence) {
        return new GetSalesUseCases(iGetSalesPersistence);
    }

    @Bean
    public IPostSalesServices iPostSalesServices(
            IPostSalesPersistence iPostSalesPersistence,
            IGetEmployeeService iGetEmployeeService
    ) {
        return new PostSalesUseCases(iPostSalesPersistence, iGetEmployeeService);
    }
}
