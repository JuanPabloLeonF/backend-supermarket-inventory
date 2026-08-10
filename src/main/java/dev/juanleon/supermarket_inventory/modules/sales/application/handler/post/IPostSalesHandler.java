package dev.juanleon.supermarket_inventory.modules.sales.application.handler.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.RequestSalesDto;

public interface IPostSalesHandler {
    ResponseRequestDto create(RequestSalesDto requestSalesDto);
}
