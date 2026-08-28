package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByPositionQueryHandler implements IRequestHandler<GetByPositionQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeService iGetEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetByPositionQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        PagedResponse<EmployeeModel> employeeModelPagedResponse = this.iGetEmployeeService.getByPosition(
                request.position(),
                data
        );

        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                employeeModelPagedResponse,
                this.iMapperEmployeeApplication::toDto
        );
    }

    @Override
    public Class<GetByPositionQuery> getRequestType() {
        return GetByPositionQuery.class;
    }
}
