package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.handler.get.IGetEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByHireDateEmployeeQueryHandler implements IRequestHandler<GetByHireDateEmployeeQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeHandler iGetEmployeeHandler;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetByHireDateEmployeeQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        return this.iGetEmployeeHandler.getByHireDate(request.hireDate(), data);
    }

    @Override
    public Class<GetByHireDateEmployeeQuery> getRequestType() {
        return GetByHireDateEmployeeQuery.class;
    }
}
