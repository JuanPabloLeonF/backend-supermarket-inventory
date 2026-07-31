package dev.juanleon.supermarket_inventory.employees.domain.useCases.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortFilesEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortUserEmployeeUpdate;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.update.IUpdateEmployeeService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties.PATH_UPLOAD_IMAGES_EMPLOYEES;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class UpdateEmployeeUseCase implements IUpdateEmployeeService {

    private final IUpdateEmployeePersistence iUpdateEmployeePersistence;
    private final IPortUserEmployeeUpdate iPortUserEmployeeUpdate;
    private final IPortFilesEmployee iPortFilesEmployee;

    public UpdateEmployeeUseCase(IUpdateEmployeePersistence iUpdateEmployeePersistence, IPortUserEmployeeUpdate iPortUserEmployeeUpdate, IPortFilesEmployee iPortFilesEmployee) {
        this.iUpdateEmployeePersistence = iUpdateEmployeePersistence;
        this.iPortUserEmployeeUpdate = iPortUserEmployeeUpdate;
        this.iPortFilesEmployee = iPortFilesEmployee;
    }

    @Override
    public ResponseModel updateByIdEmployeeAndUser(EmployeeModel employeeModel) {
        String responseEmployee = this.iUpdateEmployeePersistence.updateById(employeeModel);
        String responseUser = this.iPortUserEmployeeUpdate.updateByIdForEmployee(employeeModel.getUserModel()).message();
        return new ResponseModel(FORMAT_STRING_MESSAGE.format(responseEmployee, responseUser));
    }

    @Override
    public ResponseModel updateByIdImage(UUID id, InputFileDto inputFileDto) {
        String urlImgUpdated = this.iPortFilesEmployee.createImage(inputFileDto, PATH_UPLOAD_IMAGES_EMPLOYEES);
        String response = this.iUpdateEmployeePersistence.updateByIdImage(urlImgUpdated, id);
        return new ResponseModel(response);
    }
}
