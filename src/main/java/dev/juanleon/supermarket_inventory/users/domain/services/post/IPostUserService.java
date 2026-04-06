package dev.juanleon.supermarket_inventory.users.domain.services.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IPostUserService {
    public ResponseModel create(UserModel userModel);
}
