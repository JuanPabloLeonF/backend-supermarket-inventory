package dev.juanleon.supermarket_inventory.products.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.handler.post.IPostProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductCommandHandler implements IRequestHandler<CreateProductCommand, ResponseRequestDto> {

    private final IPostProductHandler iPostProductHandler;

    @Override
    public ResponseRequestDto handle(CreateProductCommand request) {
        return this.iPostProductHandler.create(request.requestProductDto());
    }

    @Override
    public Class<CreateProductCommand> getRequestType() {
        return CreateProductCommand.class;
    }
}
