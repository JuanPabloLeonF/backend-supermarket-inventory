package dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.update;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IUpdateEmployeePersistence {
    String updateById(EmployeeModel employeeModel);
    String updateByIdImage(String urlImg, UUID id);
}
