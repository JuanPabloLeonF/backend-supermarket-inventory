package dev.juanleon.supermarket_inventory.modules.purchases.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.RequestPurchaseDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public record CreatePurchaseCommand(
        RequestPurchaseDto requestPurchaseDto
) implements IRequest<ResponseRequestDto> { }
