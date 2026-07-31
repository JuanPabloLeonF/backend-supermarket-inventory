package dev.juanleon.supermarket_inventory.users.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IUpdateUserHandler {
    ResponseModel deleteById(UserModel userModel);
}
