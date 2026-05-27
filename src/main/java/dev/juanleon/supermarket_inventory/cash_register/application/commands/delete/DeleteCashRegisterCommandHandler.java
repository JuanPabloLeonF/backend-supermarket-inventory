package dev.juanleon.supermarket_inventory.cash_register.application.commands.delete;

import dev.juanleon.supermarket_inventory.cash_register.application.handler.delete.IDeleteCashRegisterHandler;
import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCashRegisterCommandHandler implements IRequestHandler<DeleteCashRegisterCommand, ResponseRequestDto> {

    private final IDeleteCashRegisterHandler iDeleteCashRegisterHandler;

    @Override
    public ResponseRequestDto handle(DeleteCashRegisterCommand request) {
        return this.iDeleteCashRegisterHandler.deleteById(request.id());
    }

    @Override
    public Class<DeleteCashRegisterCommand> getRequestType() {
        return DeleteCashRegisterCommand.class;
    }
}
