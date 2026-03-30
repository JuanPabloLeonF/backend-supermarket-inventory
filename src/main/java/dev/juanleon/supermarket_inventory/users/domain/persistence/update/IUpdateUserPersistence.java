package dev.juanleon.supermarket_inventory.users.domain.persistence.update;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IUpdateUserPersistence {
    String updateById(UserModel userModel);
}
