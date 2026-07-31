package dev.juanleon.supermarket_inventory.sales.domain.ports;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IPortsEmployeeSalesGet {
    EmployeeModel getByIdEmployeeForSales(UUID id);
}
