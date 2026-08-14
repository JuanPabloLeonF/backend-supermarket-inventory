package dev.juanleon.supermarket_inventory.modules.providers.application.handler.get;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetProviderHandler {
    ResponseProviderDto getById(UUID id);
    ResponseProviderDto getByName(String name);
    PagedResponse<ResponseProviderDto> getAll(PaginationRequest paginationRequest);
}
