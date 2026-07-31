package dev.juanleon.supermarket_inventory.products.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductFileDto;
import dev.juanleon.supermarket_inventory.products.application.handler.post.IPostProductHandler;
import dev.juanleon.supermarket_inventory.products.application.mappers.IMapperProductsApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductCommandHandler implements IRequestHandler<CreateProductCommand, ResponseRequestDto> {

    private final IPostProductHandler iPostProductHandler;
    private final IMapperProductsApplication iMapperProductsApplication;

    @Override
    public ResponseRequestDto handle(CreateProductCommand request) {
        RequestProductFileDto dto = this.iMapperProductsApplication.toDto(request.requestProductDto());
        return this.iPostProductHandler.create(dto);
    }

    @Override
    public Class<CreateProductCommand> getRequestType() {
        return CreateProductCommand.class;
    }
}
