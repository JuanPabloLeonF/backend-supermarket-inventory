package dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.update;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.update.IUpdateProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.update.IUpdateProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public class UpdateProviderUseCases implements IUpdateProviderService {

    private final IUpdateProviderPersistence iUpdateProviderPersistence;

    public UpdateProviderUseCases(IUpdateProviderPersistence iUpdateProviderPersistence) {
        this.iUpdateProviderPersistence = iUpdateProviderPersistence;
    }

    @Override
    public ResponseModel updateById(ProviderModel providerModel, UUID id) {
        String response = this.iUpdateProviderPersistence.updateById(providerModel, id);
        return new ResponseModel(response);
    }
}
