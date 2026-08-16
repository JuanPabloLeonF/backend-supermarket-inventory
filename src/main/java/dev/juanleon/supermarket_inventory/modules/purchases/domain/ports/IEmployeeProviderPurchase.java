package dev.juanleon.supermarket_inventory.modules.purchases.domain.ports;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IEmployeeProviderPurchase {
    EmployeeModel getEmployeeById(UUID id);
}
