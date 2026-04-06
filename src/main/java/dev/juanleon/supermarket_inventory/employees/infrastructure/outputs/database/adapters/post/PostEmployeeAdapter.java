package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NoCreateEmployeeOnDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMPLOYEE_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostEmployeeAdapter implements IPostEmployeePersistence {

    private final IEmployeeRepository iEmployeeRepository;
    private final IMapperEmployeeInfrastructure iMapperEmployeeInfrastructure;

    @Override
    public String create(EmployeeModel employeeModel) {
        EmployeeEntity entity = this.iMapperEmployeeInfrastructure.toEntity(employeeModel);
        UUID id = this.iEmployeeRepository.save(entity).getId();

        if (id == null) {
           throw new NoCreateEmployeeOnDatabaseException(employeeModel.getUserModel().getName(), employeeModel.getUserModel().getEmail());
        }

        return EMPLOYEE_CREATED_SUCCESSFULLY.format(id);
    }
}
