package dev.juanleon.supermarket_inventory.products.domain.services.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;

import java.util.UUID;

public interface IPostProductService {
    ResponseModel create(ProductModel productModel, UUID idCategories, InputFileDto inputFileDto);
}
