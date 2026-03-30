package dev.juanleon.supermarket_inventory.users.domain.services.update;

import dev.juanleon.supermarket_inventory.users.domain.models.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IUpdateUserService {
    ResponseModel updateById(UserModel userModel);
}
