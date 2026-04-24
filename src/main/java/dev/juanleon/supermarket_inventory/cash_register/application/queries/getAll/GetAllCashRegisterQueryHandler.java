package dev.juanleon.supermarket_inventory.cash_register.application.queries.getAll;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.cash_register.application.handler.get.IGetCashRegisterHandler;
import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllCashRegisterQueryHandler implements IRequestHandler<GetAllCashRegisterQuery, PagedResponse<CashRegisterResponse>> {

    private final IGetCashRegisterHandler iGetCashRegisterHandler;

    @Override
    public PagedResponse<CashRegisterResponse> handle(GetAllCashRegisterQuery request) {
        return this.iGetCashRegisterHandler.getAll(request.paginationRequest());
    }

    @Override
    public Class<GetAllCashRegisterQuery> getRequestType() {
        return GetAllCashRegisterQuery.class;
    }
}
