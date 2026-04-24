package dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.cash_register.application.handler.get.IGetCashRegisterHandler;
import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByEmployeeIdCashRegisterQueryHandler implements IRequestHandler<GetByEmployeeIdCashRegisterQuery, PagedResponse<CashRegisterResponse>> {

    private final IGetCashRegisterHandler iGetCashRegisterHandler;

    @Override
    public PagedResponse<CashRegisterResponse> handle(GetByEmployeeIdCashRegisterQuery request) {
        return this.iGetCashRegisterHandler.getByEmployeeId(
                request.employeeId(),
                request.paginationRequest()
        );
    }

    @Override
    public Class<GetByEmployeeIdCashRegisterQuery> getRequestType() {
        return GetByEmployeeIdCashRegisterQuery.class;
    }
}
