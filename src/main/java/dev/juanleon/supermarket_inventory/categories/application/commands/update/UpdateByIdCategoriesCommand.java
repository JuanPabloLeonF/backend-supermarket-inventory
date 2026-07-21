package dev.juanleon.supermarket_inventory.categories.application.commands.update;

import dev.juanleon.supermarket_inventory.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

public record UpdateByIdCategoriesCommand(RequestUpdateCategoriesDto requestUpdateCategoriesDto) implements IRequest<ResponseRequestDto> {
}
