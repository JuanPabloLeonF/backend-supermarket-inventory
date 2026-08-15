package dev.juanleon.supermarket_inventory.modules.providers.domain.services.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteProviderService {
    ResponseModel deleteById(UUID id);
}
