package dev.juanleon.supermarket_inventory.modules.providers.application.handler.update;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IUpdateProviderHandler {
    ResponseRequestDto updateById(RequestProviderDto requestProviderDto, UUID id);
}
