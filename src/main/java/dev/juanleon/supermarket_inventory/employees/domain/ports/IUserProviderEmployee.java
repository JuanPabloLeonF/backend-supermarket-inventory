package dev.juanleon.supermarket_inventory.employees.domain.ports;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

import java.util.UUID;

public interface IUserProviderEmployee {
    void checkEmailOfUserIfExist(String email);
    UserModel createUser(UserModel userModel);
    String updateUserById(UserModel userModel);
    String deleteUserById(UUID id);
}
