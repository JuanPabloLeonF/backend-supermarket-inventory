package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.EMPLOYEE_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostEmployeeAdapter implements IPostEmployeePersistence {

    private final IEmployeeRepository iEmployeeRepository;
    private final IMapperEmployeeInfrastructure iMapperEmployeeInfrastructure;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String create(EmployeeModel employeeModel) {
        EmployeeEntity entity = this.iMapperEmployeeInfrastructure.toEntity(employeeModel);
        entity.getUserEntity().setCreatedAt(LocalDateTime.now());
        entity.getUserEntity().setUpdatedAt(LocalDateTime.now());
        entity.getUserEntity().setPassword(
                this.passwordEncoder.encode(entity.getUserEntity().getPassword())
        );
        UUID id = this.iEmployeeRepository.save(entity).getId();
        return EMPLOYEE_CREATED_SUCCESSFULLY.format(id);
    }
}
