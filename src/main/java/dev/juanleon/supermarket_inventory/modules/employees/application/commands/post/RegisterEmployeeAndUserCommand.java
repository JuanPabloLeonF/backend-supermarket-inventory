package dev.juanleon.supermarket_inventory.modules.employees.application.commands.post;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestEmployeeDto;

public record RegisterEmployeeAndUserCommand (RequestEmployeeDto requestEmployeeDto) implements IRequest<ResponseRequestDto> {}
