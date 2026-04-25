package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get.IGetCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.post.IPostCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.post.IPostCashRegisterService;
import dev.juanleon.supermarket_inventory.cash_register.domain.useCases.get.GetCashRegisterUseCase;
import dev.juanleon.supermarket_inventory.cash_register.domain.useCases.post.PostCashRegisterUseCase;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCashRegisterConfiguration {

    @Bean
    public IGetCashRegisterService iGetCashRegisterService(
            IGetCashRegisterPersistence iGetCashRegisterPersistence,
            IGetEmployeeService iGetEmployeeService
    ) {
        return new GetCashRegisterUseCase(
                iGetCashRegisterPersistence,
                iGetEmployeeService
        );
    }

    @Bean
    public IPostCashRegisterService iPostCashRegisterService(
            IPostCashRegisterPersistence iPostCashRegisterPersistence,
            IGetEmployeeService iGetEmployeeService
    ) {
        return new PostCashRegisterUseCase(
                iPostCashRegisterPersistence,
                iGetEmployeeService
        );
    }
}
