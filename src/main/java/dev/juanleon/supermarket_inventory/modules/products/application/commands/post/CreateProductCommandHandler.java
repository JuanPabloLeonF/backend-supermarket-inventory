package dev.juanleon.supermarket_inventory.modules.products.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductFileDto;
import dev.juanleon.supermarket_inventory.modules.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.post.IPostProductService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler implements IRequestHandler<CreateProductCommand, ResponseRequestDto> {

    private final IPostProductService iPostProductService;
    private final IMapperProductsApplication iMapperProductsApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(CreateProductCommand request) {
        RequestProductFileDto dto = this.iMapperProductsApplication.toDto(request.requestProductDto());
        ProductModel productModel = this.iMapperProductsApplication.toModel(dto);
        ResponseModel responseModel = this.iPostProductService.create(
                productModel,
                dto.getIdCategories(),
                dto.getInputFileDto()
        );
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<CreateProductCommand> getRequestType() {
        return CreateProductCommand.class;
    }
}
