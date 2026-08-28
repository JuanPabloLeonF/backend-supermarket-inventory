package dev.juanleon.supermarket_inventory.modules.cash_register.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.modules.cash_register.application.mappers.IMapperCashRegisterApplication;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.post.IPostCashRegisterService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostCashRegisterCommandHandler implements IRequestHandler<PostCashRegisterCommand, ResponseRequestDto> {

    private final IPostCashRegisterService iPostCashRegisterService;
    private final IMapperCashRegisterApplication iMapperCashRegisterApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(PostCashRegisterCommand request) {
        CashRegisterRequest dto = request.cashRegisterRequest();
        CashRegisterModel model = this.iMapperCashRegisterApplication.toModel(dto);
        ResponseModel responseModel = this.iPostCashRegisterService.create(model, dto.getEmployeeId());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<PostCashRegisterCommand> getRequestType() {
        return PostCashRegisterCommand.class;
    }
}
