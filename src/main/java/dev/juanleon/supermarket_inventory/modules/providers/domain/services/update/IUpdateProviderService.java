package dev.juanleon.supermarket_inventory.modules.providers.domain.services.update;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IUpdateProviderService {
    ResponseModel updateById(ProviderModel providerModel, UUID id);
}
