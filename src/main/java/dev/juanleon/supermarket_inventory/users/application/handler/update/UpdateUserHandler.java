package dev.juanleon.supermarket_inventory.users.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortUserEmployeeUpdate;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.update.IUpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserHandler implements IPortUserEmployeeUpdate {

    private final IUpdateUserService iUpdateUserService;


    @Override
    public ResponseModel updateByIdForEmployee(UserModel userModel) {
        return this.iUpdateUserService.updateById(userModel);
    }
}
