package dev.juanleon.supermarket_inventory.modules.providers.application.handler.post;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public interface IPostProviderHandler {
    ResponseRequestDto create(RequestProviderDto requestProviderDto);
}
