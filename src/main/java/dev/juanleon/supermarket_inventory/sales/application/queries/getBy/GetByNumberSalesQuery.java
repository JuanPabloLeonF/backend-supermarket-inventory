package dev.juanleon.supermarket_inventory.sales.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;

import java.util.UUID;

public record GetByNumberSalesQuery(UUID numberSale) implements IRequest<SalesResponseDTO> {}
