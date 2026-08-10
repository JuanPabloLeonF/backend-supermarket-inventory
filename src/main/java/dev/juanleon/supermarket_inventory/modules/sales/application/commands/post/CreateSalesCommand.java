package dev.juanleon.supermarket_inventory.modules.sales.application.commands.post;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.RequestSalesDto;

public record CreateSalesCommand(RequestSalesDto requestSalesDto) implements IRequest<ResponseRequestDto> { }
