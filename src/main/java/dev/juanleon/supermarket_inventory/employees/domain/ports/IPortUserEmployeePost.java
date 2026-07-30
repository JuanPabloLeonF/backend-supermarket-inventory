package dev.juanleon.supermarket_inventory.employees.domain.ports;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IPortUserEmployeePost {
    UserModel create(UserModel userModel);
}
