package dev.juanleon.supermarket_inventory.sales.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;
import dev.juanleon.supermarket_inventory.sales.application.handler.get.IGetSalesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllByEmployeeIdQueryHandler implements IRequestHandler<GetAllByEmployeeIdQuery, PagedResponse<SalesResponseDTO>> {

    private final IGetSalesHandler iGetSalesHandler;

    @Override
    public PagedResponse<SalesResponseDTO> handle(GetAllByEmployeeIdQuery request) {
        PaginationRequest paginationRequest = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetSalesHandler.getAllByEmployeeId(request.employeeId(), paginationRequest);
    }

    @Override
    public Class<GetAllByEmployeeIdQuery> getRequestType() {
        return GetAllByEmployeeIdQuery.class;
    }
}
