package dev.juanleon.supermarket_inventory.modules.reports.domain.ports;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IEmployeeProviderReport {
    EmployeeModel getEmployeeById(UUID id);
}
