package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.common.utils.files.IFileUtils;
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
import dev.juanleon.supermarket_inventory.users.domain.persistence.delete.IDeleteUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.persistence.update.IUpdateUserPersistence;
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
            IPostUserPersistence iPostUserPersistence,
            IFileUtils iFileUtils
        ) {
        return new PostEmployeeUseCase(iPostEmployeePersistence, iPostUserPersistence, iFileUtils);
    }

    @Bean
    public IDeleteEmployeeService iDeleteEmployeeService(
            IDeleteEmployeePersistence iDeleteEmployeePersistence,
            IDeleteUserPersistence iDeleteUserPersistence,
            IFileUtils iFileUtils
    ) {
        return new DeleteEmployeeUseCase(iDeleteEmployeePersistence, iDeleteUserPersistence, iFileUtils);
    }

    @Bean
    public IUpdateEmployeeService iUpdateEmployeeService(
            IUpdateEmployeePersistence iUpdateEmployeePersistence,
            IGetEmployeePersistence iGetEmployeePersistence,
            IUpdateUserPersistence iUpdateUserPersistence,
            IFileUtils iFileUtils
    ) {
        return new UpdateEmployeeUseCase(
                iUpdateEmployeePersistence,
                iGetEmployeePersistence,
                iUpdateUserPersistence,
                iFileUtils
        );
    }
}
