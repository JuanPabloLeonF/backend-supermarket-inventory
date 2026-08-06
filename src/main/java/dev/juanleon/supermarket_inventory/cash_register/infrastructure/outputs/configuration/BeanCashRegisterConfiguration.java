package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.delete.IDeleteCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get.IGetCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.post.IPostCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.ports.IEmployeeProviderCashRegister;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.delete.IDeleteCashRegisterService;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.post.IPostCashRegisterService;
import dev.juanleon.supermarket_inventory.cash_register.domain.useCases.delete.DeleteCashRegisterUseCase;
import dev.juanleon.supermarket_inventory.cash_register.domain.useCases.get.GetCashRegisterUseCase;
import dev.juanleon.supermarket_inventory.cash_register.domain.useCases.post.PostCashRegisterUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCashRegisterConfiguration {

    @Bean
    public IDeleteCashRegisterService iDeleteCashRegisterService(
            IDeleteCashRegisterPersistence iDeleteCashRegisterPersistence
    ) {
        return new DeleteCashRegisterUseCase(iDeleteCashRegisterPersistence);
    }

    @Bean
    public IGetCashRegisterService iGetCashRegisterService(
            IGetCashRegisterPersistence iGetCashRegisterPersistence,
            IEmployeeProviderCashRegister iEmployeeProviderCashRegister
    ) {
        return new GetCashRegisterUseCase(
                iGetCashRegisterPersistence,
                iEmployeeProviderCashRegister
        );
    }

    @Bean
    public IPostCashRegisterService iPostCashRegisterService(
            IPostCashRegisterPersistence iPostCashRegisterPersistence,
            IEmployeeProviderCashRegister iEmployeeProviderCashRegister
    ) {
        return new PostCashRegisterUseCase(
                iPostCashRegisterPersistence,
                iEmployeeProviderCashRegister
        );
    }
}
