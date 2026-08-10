package dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteEmployeePersistence {
    String deleteEmployeeAndUser(UUID idEmployee);
}
