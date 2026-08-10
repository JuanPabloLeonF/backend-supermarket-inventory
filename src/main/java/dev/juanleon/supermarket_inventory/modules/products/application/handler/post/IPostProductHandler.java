package dev.juanleon.supermarket_inventory.modules.products.application.handler.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductFileDto;

public interface IPostProductHandler {
    ResponseRequestDto create(RequestProductFileDto requestProductFileDto);
}
