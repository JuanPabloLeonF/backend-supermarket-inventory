package dev.juanleon.supermarket_inventory.modules.providers.application.commands.delete;


import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteByIdProviderCommand(
        UUID id
) implements IRequest<ResponseRequestDto> {
}
