package dev.juanleon.supermarket_inventory.employees.domain.persistence.update;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

public interface IUpdateEmployeePersistence {
    String updateById(EmployeeModel employeeModel);
}
