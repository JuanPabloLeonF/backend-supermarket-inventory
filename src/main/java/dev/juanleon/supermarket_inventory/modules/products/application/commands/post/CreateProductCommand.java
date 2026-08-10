package dev.juanleon.supermarket_inventory.modules.products.application.commands.post;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductDto;

public record CreateProductCommand(RequestProductDto requestProductDto) implements IRequest<ResponseRequestDto> {
}
