package dev.juanleon.supermarket_inventory.cash_register.application.handler.get;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.cash_register.application.mappers.IMapperCashRegisterApplication;
import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCashRegisterHandler implements IGetCashRegisterHandler {

    private final IGetCashRegisterService iGetCashRegisterService;
    private final IMapperPaginationApp iMapperPaginationApp;
    private final IMapperCashRegisterApplication iMapperCashRegisterApplication;

    @Override
    public CashRegisterResponse getById(UUID id) {
        CashRegisterModel model = this.iGetCashRegisterService.getById(id);
        return this.iMapperCashRegisterApplication.toResponse(model);
    }

    @Override
    public PagedResponse<CashRegisterResponse> getAll(PaginationRequest paginationRequest) {
        PagedResponse<CashRegisterModel> modelPagedResponse = this.iGetCashRegisterService.getAll(paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                modelPagedResponse,
                this.iMapperCashRegisterApplication::toResponse
        );
    }

    @Override
    public PagedResponse<CashRegisterResponse> getByEmployeeId(UUID employeeId, PaginationRequest paginationRequest) {
        PagedResponse<CashRegisterModel> modelPagedResponse = this.iGetCashRegisterService.getByEmployeeId(employeeId, paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                modelPagedResponse,
                this.iMapperCashRegisterApplication::toResponse
        );
    }
}
