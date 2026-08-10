package dev.juanleon.supermarket_inventory.modules.employees.domain.services.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteEmployeeService {
    ResponseModel deleteEmployeeAndUser(UUID idEmployee);
}
