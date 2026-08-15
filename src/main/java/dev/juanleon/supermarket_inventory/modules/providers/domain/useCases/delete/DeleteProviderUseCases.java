package dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.delete.IDeleteProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.delete.IDeleteProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public class DeleteProviderUseCases implements IDeleteProviderService {

    private final IDeleteProviderPersistence iDeleteProviderPersistence;

    public DeleteProviderUseCases(IDeleteProviderPersistence iDeleteProviderPersistence) {
        this.iDeleteProviderPersistence = iDeleteProviderPersistence;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String result = iDeleteProviderPersistence.deleteById(id);
        return new ResponseModel(result);
    }
}
