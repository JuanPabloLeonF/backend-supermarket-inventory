package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get.IGetCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.cash_register.domain.useCases.get.GetCashRegisterUseCase;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import org.springframework.context.annotation.Bean;

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
}
