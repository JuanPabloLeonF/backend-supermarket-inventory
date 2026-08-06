package dev.juanleon.supermarket_inventory.employees.domain.useCases.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IFilesProviderEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IUserProviderEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.services.update.IUpdateEmployeeService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties.PATH_UPLOAD_IMAGES_EMPLOYEES;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class UpdateEmployeeUseCase implements IUpdateEmployeeService {

    private final IUpdateEmployeePersistence iUpdateEmployeePersistence;
    private final IUserProviderEmployee iUserProviderEmployee;
    private final IFilesProviderEmployee iFilesProviderEmployee;

    public UpdateEmployeeUseCase(IUpdateEmployeePersistence iUpdateEmployeePersistence, IUserProviderEmployee iUserProviderEmployee, IFilesProviderEmployee iFilesProviderEmployee) {
        this.iUpdateEmployeePersistence = iUpdateEmployeePersistence;
        this.iUserProviderEmployee = iUserProviderEmployee;
        this.iFilesProviderEmployee = iFilesProviderEmployee;
    }


    @Override
    public ResponseModel updateByIdEmployeeAndUser(EmployeeModel employeeModel) {
        String responseEmployee = this.iUpdateEmployeePersistence.updateById(employeeModel);
        String responseUser = this.iUserProviderEmployee.updateUserById(employeeModel.getUserModel());
        return new ResponseModel(FORMAT_STRING_MESSAGE.format(responseEmployee, responseUser));
    }

    @Override
    public ResponseModel updateByIdImage(UUID id, InputFileDto inputFileDto) {
        String urlImgUpdated = this.iFilesProviderEmployee.createImage(inputFileDto, PATH_UPLOAD_IMAGES_EMPLOYEES);
        String response = this.iUpdateEmployeePersistence.updateByIdImage(urlImgUpdated, id);
        return new ResponseModel(response);
    }
}
