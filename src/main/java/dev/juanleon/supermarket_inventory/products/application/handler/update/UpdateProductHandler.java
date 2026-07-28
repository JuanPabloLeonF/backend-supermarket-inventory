package dev.juanleon.supermarket_inventory.products.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductUpdateDto;
import dev.juanleon.supermarket_inventory.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.services.update.IUpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateProductHandler implements IUpdateProductHandler {

    private final IUpdateProductService iUpdateProductService;
    private final IMapperProductsApplication iMapperProductsApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto update(RequestProductUpdateDto requestProductUpdateDto) {
        ProductModel productModel = this.iMapperProductsApplication.toModelUpdate(requestProductUpdateDto);
        ResponseModel responseModel = this.iUpdateProductService.update(
                requestProductUpdateDto.getIdProduct(),
                productModel,
                requestProductUpdateDto.getIdCategories()
        );
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    @Transactional
    public ResponseRequestDto updateActive(UUID productId, Boolean active) {
        ResponseModel responseModel = this.iUpdateProductService.updateActive(productId, active);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
