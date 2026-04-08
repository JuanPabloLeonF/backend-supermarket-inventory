package dev.juanleon.supermarket_inventory.employees.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.files.IFileUtils;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;

public class PostEmployeeUseCase implements IPostEmployeeService {

    private final IPostEmployeePersistence iPostEmployeePersistence;
    private final IPostUserPersistence iPostUserPersistence;
    private final IFileUtils iFileUtils;

    public PostEmployeeUseCase(IPostEmployeePersistence iPostEmployeePersistence, IPostUserPersistence iPostUserPersistence, IFileUtils iFileUtils) {
        this.iPostEmployeePersistence = iPostEmployeePersistence;
        this.iPostUserPersistence = iPostUserPersistence;
        this.iFileUtils = iFileUtils;
    }

    @Override
    public ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel, InputFileDto inputFileDto) {
        UserModel userModelCreated = this.iPostUserPersistence.create(employeeModel.getUserModel());
        employeeModel.setUserModel(userModelCreated);
        String urlImg = this.iFileUtils.saveFile(inputFileDto);
        employeeModel.setUrlImg(urlImg);
        String message = this.iPostEmployeePersistence.create(employeeModel);
        return new ResponseModel(message);
    }
}
