package dev.juanleon.supermarket_inventory.users.domain.services.post;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IPostUserService {
    UserModel create(UserModel userModel);
}
