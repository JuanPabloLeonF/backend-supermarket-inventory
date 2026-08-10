package dev.juanleon.supermarket_inventory.modules.cash_register.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.modules.cash_register.application.handler.get.IGetCashRegisterHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllCashRegisterQueryHandler implements IRequestHandler<GetAllCashRegisterQuery, PagedResponse<CashRegisterResponse>> {

    private final IGetCashRegisterHandler iGetCashRegisterHandler;

    @Override
    public PagedResponse<CashRegisterResponse> handle(GetAllCashRegisterQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetCashRegisterHandler.getAll(data);
    }

    @Override
    public Class<GetAllCashRegisterQuery> getRequestType() {
        return GetAllCashRegisterQuery.class;
    }
}
