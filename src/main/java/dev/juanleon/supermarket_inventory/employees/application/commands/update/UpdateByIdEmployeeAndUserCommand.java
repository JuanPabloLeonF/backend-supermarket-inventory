package dev.juanleon.supermarket_inventory.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestUpdateEmployeeAndUser;

public record UpdateByIdEmployeeAndUserCommand(RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser) implements IRequest<ResponseRequestDto> {}
