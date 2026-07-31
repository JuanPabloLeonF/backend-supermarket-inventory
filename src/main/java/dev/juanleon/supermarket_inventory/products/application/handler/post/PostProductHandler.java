package dev.juanleon.supermarket_inventory.products.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductDto;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductFileDto;
import dev.juanleon.supermarket_inventory.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.services.post.IPostProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostProductHandler implements IPostProductHandler {

    private final IPostProductService iPostProductService;
    private final IMapperProductsApplication iMapperProductsApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto create(RequestProductFileDto requestProductFileDto) {
        ProductModel productModel = this.iMapperProductsApplication.toModel(requestProductFileDto);
        ResponseModel responseModel = this.iPostProductService.create(
                productModel,
                requestProductFileDto.getIdCategories(),
                requestProductFileDto.getInputFileDto()
        );
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
