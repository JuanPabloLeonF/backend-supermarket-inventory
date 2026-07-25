package dev.juanleon.supermarket_inventory.products.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductDto;
import dev.juanleon.supermarket_inventory.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.services.post.IPostProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostProductHandler implements IPostProductHandler {

    private final IPostProductService iPostProductService;
    private final IMapperProductsApplication iMapperProductsApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto create(RequestProductDto requestProductDto) {
        ProductModel productModel = this.iMapperProductsApplication.toModel(requestProductDto);
        ResponseModel responseModel = this.iPostProductService.create(productModel, requestProductDto.getIdCategories());
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
