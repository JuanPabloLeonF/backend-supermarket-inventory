package dev.juanleon.supermarket_inventory.modules.sales.domain.ports;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IEmployeeProviderSales {
    EmployeeModel getEmployeeById(UUID id);
}
