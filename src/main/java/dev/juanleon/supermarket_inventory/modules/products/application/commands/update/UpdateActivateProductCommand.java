package dev.juanleon.supermarket_inventory.modules.products.application.commands.update;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductUpdateActivateDto;


public record UpdateActivateProductCommand(
        RequestProductUpdateActivateDto requestProductUpdateActivateDto
) implements IRequest<ResponseRequestDto> {
}
