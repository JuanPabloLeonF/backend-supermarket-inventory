package dev.juanleon.supermarket_inventory.cash_register.application.commands.post;

import dev.juanleon.supermarket_inventory.cash_register.application.handler.post.IPostCashRegisterHandler;
import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostCashRegisterCommandHandler implements IRequestHandler<PostCashRegisterCommand, ResponseRequestDto> {

    private final IPostCashRegisterHandler iPostCashRegisterHandler;

    @Override
    public ResponseRequestDto handle(PostCashRegisterCommand request) {
        return this.iPostCashRegisterHandler.create(request.cashRegisterRequest());
    }

    @Override
    public Class<PostCashRegisterCommand> getRequestType() {
        return PostCashRegisterCommand.class;
    }
}
