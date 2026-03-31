package dev.juanleon.supermarket_inventory.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.employees.application.dto.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.get.IGetEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByPositionQueryHandler implements IRequestHandler<GetByPositionQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeHandler iGetEmployeeHandler;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetByPositionQuery request) {
        return this.iGetEmployeeHandler.getByPosition(request.position(), request.paginationRequest());
    }

    @Override
    public Class<GetByPositionQuery> getRequestType() {
        return GetByPositionQuery.class;
    }
}
