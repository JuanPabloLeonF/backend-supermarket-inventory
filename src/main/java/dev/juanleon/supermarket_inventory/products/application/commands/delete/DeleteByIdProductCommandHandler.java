package dev.juanleon.supermarket_inventory.products.application.commands.delete;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.handler.delete.IDeleteProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdProductCommandHandler implements IRequestHandler<DeleteByIdProductCommand, ResponseRequestDto> {

    private final IDeleteProductHandler iDeleteProductHandler;

    @Override
    public ResponseRequestDto handle(DeleteByIdProductCommand request) {
        return this.iDeleteProductHandler.deleteById(request.id());
    }

    @Override
    public Class<DeleteByIdProductCommand> getRequestType() {
        return DeleteByIdProductCommand.class;
    }
}
