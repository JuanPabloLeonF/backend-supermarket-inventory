package dev.juanleon.supermarket_inventory.employees.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.delete.IDeleteEmployeeService;
import dev.juanleon.supermarket_inventory.users.domain.services.delete.IDeleteUserService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class DeleteEmployeeUseCase implements IDeleteEmployeeService {

    private final IDeleteEmployeePersistence iDeleteEmployeePersistence;
    private final IDeleteUserService iDeleteUserService;
    private final IFilesService iFilesService;

    public DeleteEmployeeUseCase(IDeleteEmployeePersistence iDeleteEmployeePersistence, IDeleteUserService iDeleteUserService, IFilesService iFilesService) {
        this.iDeleteEmployeePersistence = iDeleteEmployeePersistence;
        this.iDeleteUserService = iDeleteUserService;
        this.iFilesService = iFilesService;
    }

    @Override
    public ResponseModel deleteEmployeeAndUser(UUID idEmployee, UUID idUser) {
        String urlImg = this.iDeleteEmployeePersistence.deleteEmployeeAndUser(idEmployee);
        String responseUser = this.iDeleteUserService.deleteById(idUser).message();
        String message = this.iFilesService.deleteFile(urlImg).message();
        return new ResponseModel(
                FORMAT_STRING_MESSAGE.format(
                        FORMAT_STRING_MESSAGE.format(
                                EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID.format(idEmployee),
                                message
                        ),
                        responseUser
                )
        );
    }
}
