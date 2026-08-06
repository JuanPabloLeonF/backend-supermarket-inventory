package dev.juanleon.supermarket_inventory.employees.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IUserProviderEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.services.delete.IDeleteEmployeeService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class DeleteEmployeeUseCase implements IDeleteEmployeeService {

    private final IDeleteEmployeePersistence iDeleteEmployeePersistence;
    private final IUserProviderEmployee iUserProviderEmployee;

    public DeleteEmployeeUseCase(IDeleteEmployeePersistence iDeleteEmployeePersistence, IUserProviderEmployee iUserProviderEmployee) {
        this.iDeleteEmployeePersistence = iDeleteEmployeePersistence;
        this.iUserProviderEmployee = iUserProviderEmployee;
    }

    @Override
    public ResponseModel deleteEmployeeAndUser(UUID idEmployee, UUID idUser) {
        String responseEmployee = this.iDeleteEmployeePersistence.deleteEmployeeAndUser(idEmployee);
        String responseUser = this.iUserProviderEmployee.deleteUserById(idUser);
        return new ResponseModel(FORMAT_STRING_MESSAGE.format(responseEmployee, responseUser));
    }
}
