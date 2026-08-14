package dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.get;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetProviderPersistence {
    ProviderModel getById(UUID id);
    ProviderModel getByName(String name);
    PagedResponse<ProviderModel> getAll(PaginationRequest paginationRequest);
}
