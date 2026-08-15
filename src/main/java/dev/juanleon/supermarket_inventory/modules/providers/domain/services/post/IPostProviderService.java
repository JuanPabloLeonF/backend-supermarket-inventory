package dev.juanleon.supermarket_inventory.modules.providers.domain.services.post;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

public interface IPostProviderService {
    ResponseModel create(ProviderModel providerModel);
}
