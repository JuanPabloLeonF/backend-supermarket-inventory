package dev.juanleon.supermarket_inventory.employees.domain.persistence.post;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

public interface IPostEmployeePersistence {
    String create(EmployeeModel employeeModel);
}
