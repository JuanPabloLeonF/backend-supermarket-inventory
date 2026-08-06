package dev.juanleon.supermarket_inventory.employees.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IFilesProviderEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IUserProviderEmployee;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

import static dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties.PATH_UPLOAD_IMAGES_EMPLOYEES;

public class PostEmployeeUseCase implements IPostEmployeeService {

    private final IPostEmployeePersistence iPostEmployeePersistence;
    private final IUserProviderEmployee iUserProviderEmployee;
    private final IFilesProviderEmployee iFilesProviderEmployee;

    public PostEmployeeUseCase(IPostEmployeePersistence iPostEmployeePersistence, IUserProviderEmployee iUserProviderEmployee, IFilesProviderEmployee iFilesProviderEmployee) {
        this.iPostEmployeePersistence = iPostEmployeePersistence;
        this.iUserProviderEmployee = iUserProviderEmployee;
        this.iFilesProviderEmployee = iFilesProviderEmployee;
    }

    @Override
    public ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel, InputFileDto inputFileDto) {
        this.iUserProviderEmployee.checkEmailOfUserIfExist(employeeModel.getUserModel().getEmail());
        UserModel userModelCreated = this.iUserProviderEmployee.createUser(employeeModel.getUserModel());
        employeeModel.setUserModel(userModelCreated);
        String urlImg = this.iFilesProviderEmployee.createImage(inputFileDto, PATH_UPLOAD_IMAGES_EMPLOYEES);
        employeeModel.setUrlImg(urlImg);
        String message = this.iPostEmployeePersistence.create(employeeModel);
        return new ResponseModel(message);
    }
}
