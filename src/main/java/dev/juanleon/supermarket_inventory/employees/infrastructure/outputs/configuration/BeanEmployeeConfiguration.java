package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.employees.domain.ports.*;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.delete.IDeleteEmployeeService;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.employees.domain.services.update.IUpdateEmployeeService;
import dev.juanleon.supermarket_inventory.employees.domain.useCases.delete.DeleteEmployeeUseCase;
import dev.juanleon.supermarket_inventory.employees.domain.useCases.get.GetEmployeeUseCase;
import dev.juanleon.supermarket_inventory.employees.domain.useCases.post.PostEmployeeUseCase;
import dev.juanleon.supermarket_inventory.employees.domain.useCases.update.UpdateEmployeeUseCase;
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
            IUserProviderEmployee iUserProviderEmployee,
            IFilesProviderEmployee iFilesProviderEmployee
    ) {
        return new PostEmployeeUseCase(
                iPostEmployeePersistence,
                iUserProviderEmployee,
                iFilesProviderEmployee
        );
    }

    @Bean
    public IDeleteEmployeeService iDeleteEmployeeService(
            IDeleteEmployeePersistence iDeleteEmployeePersistence,
            IUserProviderEmployee iUserProviderEmployee
    ) {
        return new DeleteEmployeeUseCase(
                iDeleteEmployeePersistence,
                iUserProviderEmployee
        );
    }

    @Bean
    public IUpdateEmployeeService iUpdateEmployeeService(
            IUpdateEmployeePersistence iUpdateEmployeePersistence,
            IUserProviderEmployee iUserProviderEmployee,
            IFilesProviderEmployee iFilesProviderEmployee
    ) {
        return new UpdateEmployeeUseCase(
                iUpdateEmployeePersistence,
                iUserProviderEmployee,
                iFilesProviderEmployee
        );
    }
}
