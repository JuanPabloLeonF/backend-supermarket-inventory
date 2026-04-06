package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.employees.domain.useCases.get.GetEmployeeUseCase;
import dev.juanleon.supermarket_inventory.employees.domain.useCases.post.PostEmployeeUseCase;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanEmployeeConfiguration {

    @Bean
    public IGetEmployeeService iGetEmployeeService(IGetEmployeePersistence iGetEmployeePersistence) {
        return new GetEmployeeUseCase(iGetEmployeePersistence);
    }

    @Bean
    public IPostEmployeeService iPostEmployeeService (
            IPostEmployeePersistence iPostEmployeePersistence,
            IPostUserPersistence iPostUserPersistence
        ) {
        return new PostEmployeeUseCase(iPostEmployeePersistence, iPostUserPersistence);
    }
}
