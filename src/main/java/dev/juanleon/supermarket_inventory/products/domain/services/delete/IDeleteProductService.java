package dev.juanleon.supermarket_inventory.products.domain.services.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteProductService {
    ResponseModel deleteById(UUID id);
}
