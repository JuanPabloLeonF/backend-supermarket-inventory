package dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.post;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;

public interface IPostEmployeePersistence {
    String create(EmployeeModel employeeModel);
}
