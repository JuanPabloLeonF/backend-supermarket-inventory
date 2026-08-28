package dev.juanleon.supermarket_inventory.modules.cash_register.application.commands.delete;

import dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.delete.IDeleteCashRegisterService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCashRegisterCommandHandler implements IRequestHandler<DeleteCashRegisterCommand, ResponseRequestDto> {

    private final IDeleteCashRegisterService iDeleteCashRegisterService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(DeleteCashRegisterCommand request) {
        ResponseModel responseModel = this.iDeleteCashRegisterService.deleteById(request.id());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<DeleteCashRegisterCommand> getRequestType() {
        return DeleteCashRegisterCommand.class;
    }
}
