package dev.juanleon.supermarket_inventory.users.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;

public record UpdateByIdUserCommand(RequestUpdateUserDto requestUpdateUserDto) implements IRequest<ResponseRequestDto> {}
