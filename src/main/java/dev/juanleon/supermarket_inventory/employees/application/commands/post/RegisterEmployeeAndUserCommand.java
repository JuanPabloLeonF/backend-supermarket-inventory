package dev.juanleon.supermarket_inventory.employees.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestEmployeeDto;

public record RegisterEmployeeAndUserCommand (RequestEmployeeDto requestEmployeeDto) implements IRequest<ResponseRequestDto> {}
