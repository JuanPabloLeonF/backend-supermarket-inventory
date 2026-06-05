package dev.juanleon.supermarket_inventory.sales.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesRequestDTO;

public record CreateSalesCommand(SalesRequestDTO salesRequestDTO) implements IRequest<ResponseRequestDto> { }
