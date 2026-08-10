package dev.juanleon.supermarket_inventory.modules.cash_register.domain.ports;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IEmployeeProviderCashRegister {
    EmployeeModel getEmployeeById(UUID id);
}
