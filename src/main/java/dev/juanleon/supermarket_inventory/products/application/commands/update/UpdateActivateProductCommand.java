package dev.juanleon.supermarket_inventory.products.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductUpdateActivateDto;


public record UpdateActivateProductCommand(
        RequestProductUpdateActivateDto requestProductUpdateActivateDto
) implements IRequest<ResponseRequestDto> {
}
