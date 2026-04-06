package dev.juanleon.supermarket_inventory.employees.domain.useCases.post;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.post.IPostEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;

public class PostEmployeeUseCase implements IPostEmployeeService {

    private final IPostEmployeePersistence iPostEmployeePersistence;
    private final IPostUserPersistence iPostUserPersistence;

    public PostEmployeeUseCase(IPostEmployeePersistence iPostEmployeePersistence, IPostUserPersistence iPostUserPersistence) {
        this.iPostEmployeePersistence = iPostEmployeePersistence;
        this.iPostUserPersistence = iPostUserPersistence;
    }

    @Override
    public ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel) {
        UserModel userModelCreated = this.iPostUserPersistence.create(employeeModel.getUserModel());
        employeeModel.setUserModel(userModelCreated);
        String message = this.iPostEmployeePersistence.create(employeeModel);
        return new ResponseModel(message);
    }
}
