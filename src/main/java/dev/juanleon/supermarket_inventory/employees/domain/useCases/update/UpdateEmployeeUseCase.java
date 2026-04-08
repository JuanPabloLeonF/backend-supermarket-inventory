package dev.juanleon.supermarket_inventory.employees.domain.useCases.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.files.IFileUtils;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.update.IUpdateEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.update.IUpdateEmployeeService;
import dev.juanleon.supermarket_inventory.users.domain.persistence.update.IUpdateUserPersistence;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;

public class UpdateEmployeeUseCase implements IUpdateEmployeeService {

    private final IUpdateEmployeePersistence iUpdateEmployeePersistence;
    private final IGetEmployeePersistence iGetEmployeePersistence;
    private final IUpdateUserPersistence iUpdateUserPersistence;
    private final IFileUtils iFileUtils;

    public UpdateEmployeeUseCase(IUpdateEmployeePersistence iUpdateEmployeePersistence, IGetEmployeePersistence iGetEmployeePersistence, IUpdateUserPersistence iUpdateUserPersistence, IFileUtils iFileUtils) {
        this.iUpdateEmployeePersistence = iUpdateEmployeePersistence;
        this.iGetEmployeePersistence = iGetEmployeePersistence;
        this.iUpdateUserPersistence = iUpdateUserPersistence;
        this.iFileUtils = iFileUtils;
    }

    @Override
    public ResponseModel updateByIdEmployeeAndUser(EmployeeModel employeeModel) {
        String responseEmployee = this.iUpdateEmployeePersistence.updateById(employeeModel);
        String responseUser = this.iUpdateUserPersistence.updateById(employeeModel.getUserModel());
        return new ResponseModel(FORMAT_STRING_MESSAGE.format(responseEmployee, responseUser));
    }

    @Override
    public ResponseModel updateByIdImage(UUID id, InputFileDto inputFileDto) {
        String urlImg = this.iGetEmployeePersistence.getByIdUrlImage(id);
        String urlImgUpdated = this.iFileUtils.updateFileExisting(inputFileDto, urlImg);
        String response = this.iUpdateEmployeePersistence.updateByIdImage(urlImgUpdated, id);
        return new ResponseModel(response);
    }
}
