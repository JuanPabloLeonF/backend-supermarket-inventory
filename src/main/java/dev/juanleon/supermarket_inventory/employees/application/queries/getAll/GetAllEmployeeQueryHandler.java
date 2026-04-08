package dev.juanleon.supermarket_inventory.employees.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.get.IGetEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllEmployeeQueryHandler implements IRequestHandler<GetAllEmployeeQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeHandler iGetEmployeeHandler;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetAllEmployeeQuery request) {
        return this.iGetEmployeeHandler.getAll(request.paginationRequest());
    }

    @Override
    public Class<GetAllEmployeeQuery> getRequestType() {
        return GetAllEmployeeQuery.class;
    }
}
