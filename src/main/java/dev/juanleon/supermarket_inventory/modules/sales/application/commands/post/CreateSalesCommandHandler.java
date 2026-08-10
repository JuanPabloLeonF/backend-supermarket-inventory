package dev.juanleon.supermarket_inventory.modules.sales.application.commands.post;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.handler.post.IPostSalesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSalesCommandHandler implements IRequestHandler<CreateSalesCommand, ResponseRequestDto> {

    private final IPostSalesHandler iPostSalesHandler;

    @Override
    public ResponseRequestDto handle(CreateSalesCommand request) {
        return this.iPostSalesHandler.create(request.requestSalesDto());
    }

    @Override
    public Class<CreateSalesCommand> getRequestType() {
        return CreateSalesCommand.class;
    }
}
