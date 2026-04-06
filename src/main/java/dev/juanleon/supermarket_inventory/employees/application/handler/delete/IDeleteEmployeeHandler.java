package dev.juanleon.supermarket_inventory.employees.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteEmployeeHandler {
    ResponseRequestDto deleteEmployeeAndUser(UUID idEmployee, UUID idUser);
}
