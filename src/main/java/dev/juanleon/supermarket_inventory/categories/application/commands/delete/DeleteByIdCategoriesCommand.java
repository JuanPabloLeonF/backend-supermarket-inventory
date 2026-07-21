package dev.juanleon.supermarket_inventory.categories.application.commands.delete;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteByIdCategoriesCommand(UUID id) implements IRequest<ResponseRequestDto> {
}
