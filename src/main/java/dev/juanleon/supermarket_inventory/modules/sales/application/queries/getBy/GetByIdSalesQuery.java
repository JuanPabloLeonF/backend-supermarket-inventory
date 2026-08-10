package dev.juanleon.supermarket_inventory.modules.sales.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;

import java.util.UUID;

public record GetByIdSalesQuery(UUID id) implements IRequest<ResponseSalesDto> { }
