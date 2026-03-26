package dev.juanleon.supermarket_inventory.users.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;

import java.util.List;

public record GetAllUserQuery() implements IRequest<List<ResponseUserDto>> {
}
