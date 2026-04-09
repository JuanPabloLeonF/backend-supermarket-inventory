package dev.juanleon.supermarket_inventory.employees.domain.useCases.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.files.IFileUtils;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.employees.domain.services.update.IUpdateEmployeeService;
import dev.juanleon.supermarket_inventory.users.domain.services.update.IUpdateUserService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class UpdateEmployeeUseCase implements IUpdateEmployeeService {

    private final IUpdateEmployeePersistence iUpdateEmployeePersistence;
    private final IGetEmployeeService iGetEmployeeService;
    private final IUpdateUserService iUpdateUserService;
    private final IFileUtils iFileUtils;

    public UpdateEmployeeUseCase(IUpdateEmployeePersistence iUpdateEmployeePersistence, IGetEmployeeService iGetEmployeeService, IUpdateUserService iUpdateUserService, IFileUtils iFileUtils) {
        this.iUpdateEmployeePersistence = iUpdateEmployeePersistence;
        this.iGetEmployeeService = iGetEmployeeService;
        this.iUpdateUserService = iUpdateUserService;
        this.iFileUtils = iFileUtils;
    }

    @Override
    public ResponseModel updateByIdEmployeeAndUser(EmployeeModel employeeModel) {
        String responseEmployee = this.iUpdateEmployeePersistence.updateById(employeeModel);
        String responseUser = this.iUpdateUserService.updateById(employeeModel.getUserModel()).message();
        return new ResponseModel(FORMAT_STRING_MESSAGE.format(responseEmployee, responseUser));
    }

    @Override
    public ResponseModel updateByIdImage(UUID id, InputFileDto inputFileDto) {
        String urlImg = this.iGetEmployeeService.getByIdUrlImage(id);
        String urlImgUpdated = this.iFileUtils.updateFileExisting(inputFileDto, urlImg);
        String response = this.iUpdateEmployeePersistence.updateByIdImage(urlImgUpdated, id);
        return new ResponseModel(response);
    }
}
