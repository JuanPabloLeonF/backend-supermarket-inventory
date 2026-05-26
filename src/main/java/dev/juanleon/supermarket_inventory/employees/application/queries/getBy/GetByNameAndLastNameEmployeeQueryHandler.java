package dev.juanleon.supermarket_inventory.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.get.IGetEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByNameAndLastNameEmployeeQueryHandler implements IRequestHandler<GetByNameAndLastNameEmployeeQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeHandler iGetEmployeeHandler;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetByNameAndLastNameEmployeeQuery request) {

        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        return this.iGetEmployeeHandler.getByNameAndLastName(
                request.name(),
                request.lastName(),
                data
        );
    }

    @Override
    public Class<GetByNameAndLastNameEmployeeQuery> getRequestType() {
        return GetByNameAndLastNameEmployeeQuery.class;
    }
}
