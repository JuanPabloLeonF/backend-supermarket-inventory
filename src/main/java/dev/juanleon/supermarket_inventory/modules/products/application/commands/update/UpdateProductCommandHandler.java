package dev.juanleon.supermarket_inventory.modules.products.application.commands.update;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.products.application.handler.update.IUpdateProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateProductCommandHandler implements IRequestHandler<UpdateProductCommand, ResponseRequestDto> {

    private final IUpdateProductHandler iUpdateProductHandler;

    @Override
    public ResponseRequestDto handle(UpdateProductCommand request) {
        return this.iUpdateProductHandler.update(request.requestProductUpdateDto());
    }

    @Override
    public Class<UpdateProductCommand> getRequestType() {
        return UpdateProductCommand.class;
    }
}
