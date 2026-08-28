package dev.juanleon.supermarket_inventory.modules.products.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductUpdateDto;
import dev.juanleon.supermarket_inventory.modules.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.update.IUpdateProductService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateProductCommandHandler implements IRequestHandler<UpdateProductCommand, ResponseRequestDto> {

    private final IUpdateProductService iUpdateProductService;
    private final IMapperProductsApplication iMapperProductsApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(UpdateProductCommand request) {
        RequestProductUpdateDto dto = request.requestProductUpdateDto();
        ProductModel productModel = this.iMapperProductsApplication.toModelUpdate(dto);
        ResponseModel responseModel = this.iUpdateProductService.update(
                dto.getIdProduct(),
                productModel,
                dto.getIdCategories()
        );
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<UpdateProductCommand> getRequestType() {
        return UpdateProductCommand.class;
    }
}
