package dev.juanleon.supermarket_inventory.employees.domain.ports;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

import java.util.UUID;

public interface IPortUserEmployeeDelete {
    ResponseModel deleteByIdForEmployee(UUID id);
}
