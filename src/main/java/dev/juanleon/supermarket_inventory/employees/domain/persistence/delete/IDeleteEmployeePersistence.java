package dev.juanleon.supermarket_inventory.employees.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteEmployeePersistence {
    String deleteEmployeeAndUser(UUID idEmployee);
}
