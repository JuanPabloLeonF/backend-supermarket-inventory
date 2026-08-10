package dev.juanleon.supermarket_inventory.modules.categories.application.commands.delete;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteByIdCategoriesCommand(UUID id) implements IRequest<ResponseRequestDto> {
}
