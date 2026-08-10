package dev.juanleon.supermarket_inventory.modules.categories.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public record UpdateByIdCategoriesCommand(RequestUpdateCategoriesDto requestUpdateCategoriesDto) implements IRequest<ResponseRequestDto> {
}
