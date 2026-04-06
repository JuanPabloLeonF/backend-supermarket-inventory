package dev.juanleon.supermarket_inventory.employees.domain.services.post;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IPostEmployeeService {
    ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel);
}
