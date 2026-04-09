package dev.juanleon.supermarket_inventory.employees.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository.IFileUtils;
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
    private final IFileUtils iFileUtils;
    private final AppConfigurationProperties appConfigurationProperties;

    public PostEmployeeUseCase(IPostEmployeePersistence iPostEmployeePersistence, IPostUserService iPostUserService, IGetUserService iGetUserService, IFileUtils iFileUtils, AppConfigurationProperties appConfigurationProperties) {
        this.iPostEmployeePersistence = iPostEmployeePersistence;
        this.iPostUserService = iPostUserService;
        this.iGetUserService = iGetUserService;
        this.iFileUtils = iFileUtils;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel, InputFileDto inputFileDto) {
        this.iGetUserService.checkEmailIfExist(employeeModel.getUserModel().getEmail());
        UserModel userModelCreated = this.iPostUserService.create(employeeModel.getUserModel());
        employeeModel.setUserModel(userModelCreated);
        String urlImg = this.iFileUtils.saveFile(inputFileDto, this.appConfigurationProperties.getPathUploadImagesEmployees());
        employeeModel.setUrlImg(urlImg);
        String message = this.iPostEmployeePersistence.create(employeeModel);
        return new ResponseModel(message);
    }
}
