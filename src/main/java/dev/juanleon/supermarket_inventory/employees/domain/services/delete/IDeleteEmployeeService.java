package dev.juanleon.supermarket_inventory.employees.domain.services.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteEmployeeService {
    ResponseModel deleteEmployeeAndUser(UUID idEmployee, UUID idUser);
}
