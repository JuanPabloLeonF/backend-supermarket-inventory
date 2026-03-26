package dev.juanleon.supermarket_inventory.users.domain.services.get;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

import java.util.List;
import java.util.UUID;

public interface IGetUserService {
    public List<UserModel> getAll();
    public UserModel getById(UUID id);
    public List<UserModel> getByName(String name);
    public List<UserModel> getByLastName(String lastName);
}
