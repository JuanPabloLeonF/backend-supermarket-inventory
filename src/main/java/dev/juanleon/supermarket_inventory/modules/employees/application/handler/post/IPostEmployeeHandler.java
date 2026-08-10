package dev.juanleon.supermarket_inventory.modules.employees.application.handler.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestRegisterEmployeeDto;

public interface IPostEmployeeHandler {
    ResponseRequestDto registerEmployeeAndUser(RequestRegisterEmployeeDto requestRegisterEmployeeDto);
}
