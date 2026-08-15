package dev.juanleon.supermarket_inventory.modules.providers.application.commands.update;


import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record UpdateByIdProviderCommand(
        UUID id,
        RequestProviderDto requestProviderDto
) implements IRequest<ResponseRequestDto> {
}
