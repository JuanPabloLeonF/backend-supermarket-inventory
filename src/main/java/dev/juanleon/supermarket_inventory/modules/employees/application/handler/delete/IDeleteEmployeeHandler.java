package dev.juanleon.supermarket_inventory.modules.employees.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteEmployeeHandler {
    ResponseRequestDto deleteEmployeeAndUser(UUID idEmployee);
}
