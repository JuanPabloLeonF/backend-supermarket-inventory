package dev.juanleon.supermarket_inventory.products.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductUpdateDto;

public record UpdateProductCommand(
        RequestProductUpdateDto requestProductUpdateDto
) implements IRequest<ResponseRequestDto> {
}
