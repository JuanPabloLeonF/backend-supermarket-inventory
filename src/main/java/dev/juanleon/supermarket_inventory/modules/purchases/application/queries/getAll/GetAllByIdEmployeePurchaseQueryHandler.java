package dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.ResponsePurchaseDto;
import dev.juanleon.supermarket_inventory.modules.purchases.application.mappers.IMapperPurchaseApplication;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.services.get.IGetPurchaseService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllByIdEmployeePurchaseQueryHandler implements IRequestHandler<GetAllByIdEmployeePurchaseQuery, PagedResponse<ResponsePurchaseDto>> {

    private final IGetPurchaseService iGetPurchaseService;
    private final IMapperPaginationApp iMapperPaginationApp;
    private final IMapperPurchaseApplication iMapperPurchaseApplication;

    @Override
    public PagedResponse<ResponsePurchaseDto> handle(GetAllByIdEmployeePurchaseQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        PagedResponse<PurchaseModel> pagedResponse = this.iGetPurchaseService.getAllByIdEmployee(
                request.idEmployee(),
                data
        );
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                pagedResponse,
                this.iMapperPurchaseApplication::toResponse
        );
    }

    @Override
    public Class<GetAllByIdEmployeePurchaseQuery> getRequestType() {
        return GetAllByIdEmployeePurchaseQuery.class;
    }
}
