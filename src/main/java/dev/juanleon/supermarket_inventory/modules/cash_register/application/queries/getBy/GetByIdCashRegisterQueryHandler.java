package dev.juanleon.supermarket_inventory.modules.cash_register.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.modules.cash_register.application.handler.get.IGetCashRegisterHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdCashRegisterQueryHandler implements IRequestHandler<GetByIdCashRegisterQuery, CashRegisterResponse> {

    private final IGetCashRegisterHandler iGetCashRegisterHandler;

    @Override
    public CashRegisterResponse handle(GetByIdCashRegisterQuery request) {
        return this.iGetCashRegisterHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdCashRegisterQuery> getRequestType() {
        return GetByIdCashRegisterQuery.class;
    }
}
