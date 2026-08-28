package dev.juanleon.supermarket_inventory.modules.cash_register.application.queries.getAll;

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
public class GetAllCashRegisterQueryHandler implements IRequestHandler<GetAllCashRegisterQuery, PagedResponse<CashRegisterResponse>> {

    private final IGetCashRegisterService iGetCashRegisterService;
    private final IMapperCashRegisterApplication iMapperCashRegisterApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<CashRegisterResponse> handle(GetAllCashRegisterQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        PagedResponse<CashRegisterModel> modelPagedResponse = this.iGetCashRegisterService.getAll(data);

        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                modelPagedResponse,
                this.iMapperCashRegisterApplication::toResponse
        );
    }

    @Override
    public Class<GetAllCashRegisterQuery> getRequestType() {
        return GetAllCashRegisterQuery.class;
    }
}
