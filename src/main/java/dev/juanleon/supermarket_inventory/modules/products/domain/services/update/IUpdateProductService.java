package dev.juanleon.supermarket_inventory.modules.products.domain.services.update;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;

import java.util.UUID;

public interface IUpdateProductService {
    ResponseModel update(UUID productId, ProductModel productModel, UUID categoryId);
    ResponseModel updateActive(UUID productId, Boolean active);
    ResponseModel updateUrlImg(UUID productId, InputFileDto inputFileDto);
}