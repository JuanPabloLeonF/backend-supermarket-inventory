package dev.juanleon.supermarket_inventory.products.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductDto;

public record CreateProductCommand(RequestProductDto requestProductDto) implements IRequest<ResponseRequestDto> {
}
