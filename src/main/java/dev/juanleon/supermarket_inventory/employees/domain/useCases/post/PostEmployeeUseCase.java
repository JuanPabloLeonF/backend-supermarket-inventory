package dev.juanleon.supermarket_inventory.employees.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.get.IGetUserService;
import dev.juanleon.supermarket_inventory.users.domain.services.post.IPostUserService;

public class PostEmployeeUseCase implements IPostEmployeeService {

    private final IPostEmployeePersistence iPostEmployeePersistence;
    private final IPostUserService iPostUserService;
    private final IGetUserService iGetUserService;
    private final IFilesService iFilesService;

    public PostEmployeeUseCase(IPostEmployeePersistence iPostEmployeePersistence, IPostUserService iPostUserService, IGetUserService iGetUserService, IFilesService iFilesService) {
        this.iPostEmployeePersistence = iPostEmployeePersistence;
        this.iPostUserService = iPostUserService;
        this.iGetUserService = iGetUserService;
        this.iFilesService = iFilesService;
    }

    @Override
    public ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel, InputFileDto inputFileDto) {
        this.iGetUserService.checkEmailIfExist(employeeModel.getUserModel().getEmail());
        UserModel userModelCreated = this.iPostUserService.create(employeeModel.getUserModel());
        employeeModel.setUserModel(userModelCreated);
        String urlImg = this.iFilesService.createImage(inputFileDto);
        employeeModel.setUrlImg(urlImg);
        String message = this.iPostEmployeePersistence.create(employeeModel);
        return new ResponseModel(message);
    }
}
