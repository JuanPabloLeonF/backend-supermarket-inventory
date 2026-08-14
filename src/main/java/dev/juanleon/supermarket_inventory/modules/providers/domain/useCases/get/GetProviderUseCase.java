package dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.get;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.get.IGetProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.get.IGetProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public class GetProviderUseCase implements IGetProviderService {

    private final IGetProviderPersistence iGetProviderPersistence;

    public GetProviderUseCase(IGetProviderPersistence iGetProviderPersistence) {
        this.iGetProviderPersistence = iGetProviderPersistence;
    }

    @Override
    public ProviderModel getById(UUID id) {
        return this.iGetProviderPersistence.getById(id);
    }

    @Override
    public ProviderModel getByName(String name) {
        return this.iGetProviderPersistence.getByName(name);
    }

    @Override
    public PagedResponse<ProviderModel> getAll(PaginationRequest paginationRequest) {
        return this.iGetProviderPersistence.getAll(paginationRequest);
    }
}
