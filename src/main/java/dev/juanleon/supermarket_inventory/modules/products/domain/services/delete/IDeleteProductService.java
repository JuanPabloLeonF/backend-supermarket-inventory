package dev.juanleon.supermarket_inventory.modules.products.domain.services.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteProductService {
    ResponseModel deleteById(UUID id);
}
