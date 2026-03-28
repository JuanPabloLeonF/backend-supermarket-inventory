package dev.juanleon.supermarket_inventory.users.domain.persistence.post;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IPostUserPersistence {
    public String create(UserModel userModel);
}
