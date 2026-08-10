package dev.juanleon.supermarket_inventory.modules.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestUpdateEmployeeAndUser;

public record UpdateByIdEmployeeAndUserCommand(RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser) implements IRequest<ResponseRequestDto> {}
