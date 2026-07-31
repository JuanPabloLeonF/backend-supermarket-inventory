package dev.juanleon.supermarket_inventory.products.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductFileDto;

public interface IPostProductHandler {
    ResponseRequestDto create(RequestProductFileDto requestProductFileDto);
}
