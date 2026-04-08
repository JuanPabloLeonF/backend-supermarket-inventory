package dev.juanleon.supermarket_inventory.employees.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestEmployeeDto;

public interface IPostEmployeeHandler {
    ResponseRequestDto registerEmployeeAndUser(RequestEmployeeDto requestEmployeeDto);
}
