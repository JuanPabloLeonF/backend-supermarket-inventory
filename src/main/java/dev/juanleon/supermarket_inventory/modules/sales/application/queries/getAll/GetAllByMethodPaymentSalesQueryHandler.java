package dev.juanleon.supermarket_inventory.modules.sales.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.handler.get.IGetSalesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllByMethodPaymentSalesQueryHandler implements IRequestHandler<GetAllByMethodPaymentSalesQuery, PagedResponse<ResponseSalesDto>> {

    private final IGetSalesHandler iGetSalesHandler;

    @Override
    public PagedResponse<ResponseSalesDto> handle(GetAllByMethodPaymentSalesQuery request) {
        PaginationRequest paginationRequest = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetSalesHandler.getAllByMethodPayment(request.methodPayment(), paginationRequest);
    }

    @Override
    public Class<GetAllByMethodPaymentSalesQuery> getRequestType() {
        return GetAllByMethodPaymentSalesQuery.class;
    }
}
