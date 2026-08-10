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
public class GetByPositionQueryHandler implements IRequestHandler<GetByPositionQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeHandler iGetEmployeeHandler;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetByPositionQuery request) {

        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        return this.iGetEmployeeHandler.getByPosition(
                request.position(),
                data
        );
    }

    @Override
    public Class<GetByPositionQuery> getRequestType() {
        return GetByPositionQuery.class;
    }
}
