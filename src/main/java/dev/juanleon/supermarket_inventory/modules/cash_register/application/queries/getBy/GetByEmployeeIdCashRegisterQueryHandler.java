package dev.juanleon.supermarket_inventory.modules.cash_register.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.modules.cash_register.application.mappers.IMapperCashRegisterApplication;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByEmployeeIdCashRegisterQueryHandler implements IRequestHandler<GetByEmployeeIdCashRegisterQuery, PagedResponse<CashRegisterResponse>> {

    private final IGetCashRegisterService iGetCashRegisterService;
    private final IMapperPaginationApp iMapperPaginationApp;
    private final IMapperCashRegisterApplication iMapperCashRegisterApplication;

    @Override
    public PagedResponse<CashRegisterResponse> handle(GetByEmployeeIdCashRegisterQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        PagedResponse<CashRegisterModel> modelPagedResponse = this.iGetCashRegisterService.getByEmployeeId(request.employeeId(), data);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                modelPagedResponse,
                this.iMapperCashRegisterApplication::toResponse
        );
    }

    @Override
    public Class<GetByEmployeeIdCashRegisterQuery> getRequestType() {
        return GetByEmployeeIdCashRegisterQuery.class;
    }
}
