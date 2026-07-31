package dev.juanleon.supermarket_inventory.employees.domain.ports;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;

public interface IPortUserEmployeeUpdate {
    ResponseModel updateByIdForEmployee(UserModel userModel);
}
