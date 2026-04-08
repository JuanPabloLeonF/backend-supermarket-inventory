package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.adapters.update;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMPLOYEE_UPDATE_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class UpdateEmployeeAdapter implements IUpdateEmployeePersistence {

    private final IEmployeeRepository iEmployeeRepository;

    @Override
    public String updateById(EmployeeModel employeeModel) {
        return this.iEmployeeRepository.findById(employeeModel.getId())
                .map(entity -> {
                    entity.setNationalId(employeeModel.getNationalId());
                    entity.setPhone(employeeModel.getPhone());
                    entity.setAddress(employeeModel.getAddress());
                    entity.setPosition(employeeModel.getPosition());
                    entity.setSalary(employeeModel.getSalary());
                    entity.setHireDate(employeeModel.getHireDate());
                    this.iEmployeeRepository.save(entity);
                    return EMPLOYEE_UPDATE_SUCCESSFULLY_BY_ID.format(entity.getId());
                }).orElseThrow(() -> new NotFoundEmployeeException(employeeModel.getId()));
    }
}
