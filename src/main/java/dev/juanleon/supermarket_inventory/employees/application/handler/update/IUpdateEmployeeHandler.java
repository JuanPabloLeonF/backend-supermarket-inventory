package dev.juanleon.supermarket_inventory.employees.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestUpdateEmployeeAndUser;

import java.util.UUID;

public interface IUpdateEmployeeHandler {
    ResponseRequestDto updateByIdEmployeeAndUser(RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser);
    ResponseRequestDto updateByIdImage(InputFileDto inputFileDto, UUID id);
}
