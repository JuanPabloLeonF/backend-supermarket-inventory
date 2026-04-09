package dev.juanleon.supermarket_inventory.users.domain.persistence.get;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

import java.util.List;
import java.util.UUID;

public interface IGetUserPersistence {
    List<UserModel> getAll();
    UserModel getById(UUID id);
    List<UserModel> getByName(String name);
    List<UserModel> getByLastName(String lastName);
    void checkEmailIfExist(String email);
}
