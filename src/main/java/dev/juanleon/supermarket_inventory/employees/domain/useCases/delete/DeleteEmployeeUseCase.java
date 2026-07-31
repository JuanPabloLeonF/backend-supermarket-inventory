package dev.juanleon.supermarket_inventory.employees.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortFilesEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortUserEmployeeDelete;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.delete.IDeleteEmployeeService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class DeleteEmployeeUseCase implements IDeleteEmployeeService {

    private final IDeleteEmployeePersistence iDeleteEmployeePersistence;
    private final IPortUserEmployeeDelete iPortUserEmployeeDelete;
    private final IPortFilesEmployee iPortFilesEmployee;
    private final AppConfigurationProperties appConfigurationProperties;


    public DeleteEmployeeUseCase(IDeleteEmployeePersistence iDeleteEmployeePersistence, IPortUserEmployeeDelete iPortUserEmployeeDelete, IPortFilesEmployee iPortFilesEmployee, AppConfigurationProperties appConfigurationProperties) {
        this.iDeleteEmployeePersistence = iDeleteEmployeePersistence;
        this.iPortUserEmployeeDelete = iPortUserEmployeeDelete;
        this.iPortFilesEmployee = iPortFilesEmployee;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel deleteEmployeeAndUser(UUID idEmployee, UUID idUser) {
        String urlImg = this.iDeleteEmployeePersistence.deleteEmployeeAndUser(idEmployee);
        String responseUser = this.iPortUserEmployeeDelete.deleteByIdForEmployee(idUser).message();
        String message = this.iPortFilesEmployee.deleteImage(
                urlImg,
                this.appConfigurationProperties.getPathUploadImagesEmployees()
        ).message();
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
