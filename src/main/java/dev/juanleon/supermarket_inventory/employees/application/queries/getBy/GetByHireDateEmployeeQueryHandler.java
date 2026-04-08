package dev.juanleon.supermarket_inventory.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.get.IGetEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByHireDateEmployeeQueryHandler implements IRequestHandler<GetByHireDateEmployeeQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeHandler iGetEmployeeHandler;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetByHireDateEmployeeQuery request) {
        return this.iGetEmployeeHandler.getByHireDate(request.hireDate(), request.paginationRequest());
    }

    @Override
    public Class<GetByHireDateEmployeeQuery> getRequestType() {
        return GetByHireDateEmployeeQuery.class;
    }
}
