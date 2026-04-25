package dev.juanleon.supermarket_inventory.cash_register.application.handler.post;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.cash_register.application.mappers.IMapperCashRegisterApplication;
import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.post.IPostCashRegisterService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCashRegisterHandler implements IPostCashRegisterHandler {

    private final IPostCashRegisterService iPostCashRegisterService;
    private final IMapperCashRegisterApplication iMapperCashRegisterApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto create(CashRegisterRequest cashRegisterRequest) {
        CashRegisterModel model = this.iMapperCashRegisterApplication.toModel(cashRegisterRequest);
        ResponseModel responseModel = this.iPostCashRegisterService.create(model);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
