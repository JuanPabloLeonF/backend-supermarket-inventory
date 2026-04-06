package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteEmployeeAdapter implements IDeleteEmployeePersistence {

    private final IEmployeeRepository iEmployeeRepository;

    @Override
    public String deleteEmployeeAndUser(UUID idEmployee) {
        return this.iEmployeeRepository.findById(idEmployee)
                .map(entity -> {
                    this.iEmployeeRepository.deleteById(entity.getId());
                    return entity.getUrlImg();
                }).orElseThrow(() -> new NotFoundEmployeeException(idEmployee));
    }
}
