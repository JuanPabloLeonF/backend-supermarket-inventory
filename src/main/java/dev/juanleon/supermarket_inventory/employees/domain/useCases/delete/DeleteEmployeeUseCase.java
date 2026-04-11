package dev.juanleon.supermarket_inventory.employees.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository.IFileUtils;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.delete.IDeleteEmployeeService;
import dev.juanleon.supermarket_inventory.users.domain.services.delete.IDeleteUserService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class DeleteEmployeeUseCase implements IDeleteEmployeeService {

    private final IDeleteEmployeePersistence iDeleteEmployeePersistence;
    private final IDeleteUserService iDeleteUserService;
    private final IFileUtils iFileUtils;
    private final AppConfigurationProperties appConfigurationProperties;

    public DeleteEmployeeUseCase(IDeleteEmployeePersistence iDeleteEmployeePersistence, IDeleteUserService iDeleteUserService, IFileUtils iFileUtils, AppConfigurationProperties appConfigurationProperties) {
        this.iDeleteEmployeePersistence = iDeleteEmployeePersistence;
        this.iDeleteUserService = iDeleteUserService;
        this.iFileUtils = iFileUtils;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel deleteEmployeeAndUser(UUID idEmployee, UUID idUser) {
        String urlImg = this.iDeleteEmployeePersistence.deleteEmployeeAndUser(idEmployee);
        String responseUser = this.iDeleteUserService.deleteById(idUser).message();
        this.iFileUtils.deleteFile(, this.appConfigurationProperties.getPathUploadImagesEmployees());
        return new ResponseModel(
                FORMAT_STRING_MESSAGE.format(
                        EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID.format(idEmployee),
                        responseUser
                )
        );
    }
}
