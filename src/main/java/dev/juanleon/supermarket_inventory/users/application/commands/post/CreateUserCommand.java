package dev.juanleon.supermarket_inventory.users.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;

public record CreateUserCommand(RequestUserDto requestUserDto) implements IRequest<ResponseUserDto> {
}
