package dev.juanleon.supermarket_inventory.users.domain.useCases.update;

import dev.juanleon.supermarket_inventory.users.domain.models.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.update.IUpdateUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.services.update.IUpdateUserService;

public class UpdateUserUseCase implements IUpdateUserService {

    private final IUpdateUserPersistence iUpdateUserPersistence;

    public UpdateUserUseCase(IUpdateUserPersistence iUpdateUserPersistence) {
        this.iUpdateUserPersistence = iUpdateUserPersistence;
    }

    @Override
    public ResponseModel updateById(UserModel userModel) {
        String response = this.iUpdateUserPersistence.updateById(userModel);
        return new ResponseModel(response);
    }
}
