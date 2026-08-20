package dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.ResponsePurchaseDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;

import java.util.UUID;

public record GetByIdPurchaseQuery(UUID id) implements IRequest<ResponsePurchaseDto> {}
