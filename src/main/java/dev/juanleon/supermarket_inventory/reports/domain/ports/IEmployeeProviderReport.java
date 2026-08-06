package dev.juanleon.supermarket_inventory.reports.domain.ports;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IEmployeeProviderReport {
    EmployeeModel getEmployeeById(UUID id);
}
