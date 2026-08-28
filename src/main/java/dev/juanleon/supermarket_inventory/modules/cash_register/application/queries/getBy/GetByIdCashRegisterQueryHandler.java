package dev.juanleon.supermarket_inventory.modules.cash_register.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.modules.cash_register.application.mappers.IMapperCashRegisterApplication;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdCashRegisterQueryHandler implements IRequestHandler<GetByIdCashRegisterQuery, CashRegisterResponse> {

    private final IGetCashRegisterService iGetCashRegisterService;
    private final IMapperCashRegisterApplication iMapperCashRegisterApplication;

    @Override
    public CashRegisterResponse handle(GetByIdCashRegisterQuery request) {
        CashRegisterModel model = this.iGetCashRegisterService.getById(request.id());
        return this.iMapperCashRegisterApplication.toResponse(model);
    }

    @Override
    public Class<GetByIdCashRegisterQuery> getRequestType() {
        return GetByIdCashRegisterQuery.class;
    }
}
