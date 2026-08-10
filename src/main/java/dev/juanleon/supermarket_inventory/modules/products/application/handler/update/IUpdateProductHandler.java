package dev.juanleon.supermarket_inventory.modules.products.application.handler.update;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductUpdateDto;

import java.util.UUID;

public interface IUpdateProductHandler {
    ResponseRequestDto update(RequestProductUpdateDto requestProductUpdateDto);
    ResponseRequestDto updateActive(UUID productId, Boolean active);
    ResponseRequestDto updateUrlImg(UUID productId, InputFileDto inputFileDto);
}
