package dev.juanleon.supermarket_inventory.modules.providers.domain.services.get;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetProviderService {
    ProviderModel getById(UUID id);
    ProviderModel getByName(String name);
    PagedResponse<ProviderModel> getAll(PaginationRequest paginationRequest);
}
