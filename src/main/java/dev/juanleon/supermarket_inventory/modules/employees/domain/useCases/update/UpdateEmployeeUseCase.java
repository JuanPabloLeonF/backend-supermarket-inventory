package dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.update;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.IFilesProviderEmployee;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.update.IUpdateEmployeeService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp.PATH_UPLOAD_IMAGES_EMPLOYEES;

public class UpdateEmployeeUseCase implements IUpdateEmployeeService {

    private final IUpdateEmployeePersistence iUpdateEmployeePersistence;
    private final IFilesProviderEmployee iFilesProviderEmployee;

    public UpdateEmployeeUseCase(IUpdateEmployeePersistence iUpdateEmployeePersistence, IFilesProviderEmployee iFilesProviderEmployee) {
        this.iUpdateEmployeePersistence = iUpdateEmployeePersistence;
        this.iFilesProviderEmployee = iFilesProviderEmployee;
    }

    @Override
    public ResponseModel updateByIdEmployeeAndUser(EmployeeModel employeeModel) {
        String response = this.iUpdateEmployeePersistence.updateById(employeeModel);
        return new ResponseModel(response);
    }

    @Override
    public ResponseModel updateByIdImage(UUID id, InputFileDto inputFileDto) {
        String urlImgUpdated = this.iFilesProviderEmployee.createImage(inputFileDto, PATH_UPLOAD_IMAGES_EMPLOYEES);
        String response = this.iUpdateEmployeePersistence.updateByIdImage(urlImgUpdated, id);
        return new ResponseModel(response);
    }
}
