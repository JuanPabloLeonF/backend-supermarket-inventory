package dev.juanleon.supermarket_inventory.modules.providers.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public record CreateProviderCommand(
        RequestProviderDto requestProviderDto
) implements IRequest<ResponseRequestDto> {
}
