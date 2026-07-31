package dev.juanleon.supermarket_inventory.employees.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortFilesEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortUserEmployeeGet;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortUserEmployeePost;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public class PostEmployeeUseCase implements IPostEmployeeService {

    private final IPostEmployeePersistence iPostEmployeePersistence;
    private final IPortUserEmployeePost iPortUserEmployeePost;
    private final IPortUserEmployeeGet iPortUserEmployeeGet;
    private final IPortFilesEmployee iPortFilesEmployee;
    private final AppConfigurationProperties appConfigurationProperties;

    public PostEmployeeUseCase(IPostEmployeePersistence iPostEmployeePersistence, IPortUserEmployeePost iPortUserEmployeePost, IPortUserEmployeeGet iPortUserEmployeeGet, IPortFilesEmployee iPortFilesEmployee, AppConfigurationProperties appConfigurationProperties) {
        this.iPostEmployeePersistence = iPostEmployeePersistence;
        this.iPortUserEmployeePost = iPortUserEmployeePost;
        this.iPortUserEmployeeGet = iPortUserEmployeeGet;
        this.iPortFilesEmployee = iPortFilesEmployee;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel, InputFileDto inputFileDto) {
        this.iPortUserEmployeeGet.checkEmailIfExist(employeeModel.getUserModel().getEmail());
        UserModel userModelCreated = this.iPortUserEmployeePost.create(employeeModel.getUserModel());
        employeeModel.setUserModel(userModelCreated);
        String urlImg = this.iPortFilesEmployee.createImage(
                inputFileDto,
                this.appConfigurationProperties.getPathUploadImagesEmployees()
        );
        employeeModel.setUrlImg(urlImg);
        String message = this.iPostEmployeePersistence.create(employeeModel);
        return new ResponseModel(message);
    }
}
