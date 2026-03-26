package dev.juanleon.supermarket_inventory.users.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;

import java.util.UUID;

public record GetByIdUserQuery(UUID id) implements IRequest<ResponseUserDto> {
}
