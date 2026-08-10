package dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.delete.IDeleteEmployeeService;

import java.util.UUID;

public class DeleteEmployeeUseCase implements IDeleteEmployeeService {

    private final IDeleteEmployeePersistence iDeleteEmployeePersistence;

    public DeleteEmployeeUseCase(IDeleteEmployeePersistence iDeleteEmployeePersistence) {
        this.iDeleteEmployeePersistence = iDeleteEmployeePersistence;
    }

    @Override
    public ResponseModel deleteEmployeeAndUser(UUID idEmployee) {
        String response = this.iDeleteEmployeePersistence.deleteEmployeeAndUser(idEmployee);
        return new ResponseModel(response);
    }
}
