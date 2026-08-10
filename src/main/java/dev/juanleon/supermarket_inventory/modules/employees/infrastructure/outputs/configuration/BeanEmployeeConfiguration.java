package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.IFilesProviderEmployee;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.delete.IDeleteEmployeeService;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.update.IUpdateEmployeeService;
import dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.delete.DeleteEmployeeUseCase;
import dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.get.GetEmployeeUseCase;
import dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.post.PostEmployeeUseCase;
import dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.update.UpdateEmployeeUseCase;
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
            IFilesProviderEmployee iFilesProviderEmployee
    ) {
        return new PostEmployeeUseCase(
                iPostEmployeePersistence,
                iFilesProviderEmployee
        );
    }

    @Bean
    public IDeleteEmployeeService iDeleteEmployeeService(IDeleteEmployeePersistence iDeleteEmployeePersistence) {
        return new DeleteEmployeeUseCase(iDeleteEmployeePersistence);
    }

    @Bean
    public IUpdateEmployeeService iUpdateEmployeeService(
            IUpdateEmployeePersistence iUpdateEmployeePersistence,
            IFilesProviderEmployee iFilesProviderEmployee
    ) {
        return new UpdateEmployeeUseCase(
                iUpdateEmployeePersistence,
                iFilesProviderEmployee
        );
    }
}
