package dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.post;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.post.IPostProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.post.IPostProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

public class PostProviderUseCase implements IPostProviderService {

    private final IPostProviderPersistence iPostProviderPersistence;

    public PostProviderUseCase(IPostProviderPersistence iPostProviderPersistence) {
        this.iPostProviderPersistence = iPostProviderPersistence;
    }

    @Override
    public ResponseModel create(ProviderModel providerModel) {
        String response = iPostProviderPersistence.create(providerModel);
        return new ResponseModel(response);
    }
}
