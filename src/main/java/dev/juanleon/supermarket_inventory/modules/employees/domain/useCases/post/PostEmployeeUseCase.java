package dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.IFilesProviderEmployee;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import static dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp.PATH_UPLOAD_IMAGES_EMPLOYEES;

public class PostEmployeeUseCase implements IPostEmployeeService {

    private final IPostEmployeePersistence iPostEmployeePersistence;
    private final IFilesProviderEmployee iFilesProviderEmployee;

    public PostEmployeeUseCase(IPostEmployeePersistence iPostEmployeePersistence, IFilesProviderEmployee iFilesProviderEmployee) {
        this.iPostEmployeePersistence = iPostEmployeePersistence;
        this.iFilesProviderEmployee = iFilesProviderEmployee;
    }

    @Override
    public ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel, InputFileDto inputFileDto) {
        String urlImg = this.iFilesProviderEmployee.createImage(inputFileDto, PATH_UPLOAD_IMAGES_EMPLOYEES);
        employeeModel.setUrlImg(urlImg);
        String message = this.iPostEmployeePersistence.create(employeeModel);
        return new ResponseModel(message);
    }
}
