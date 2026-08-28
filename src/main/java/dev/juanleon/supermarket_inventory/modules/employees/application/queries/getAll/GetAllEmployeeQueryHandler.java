package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getAll;

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
public class GetAllEmployeeQueryHandler implements IRequestHandler<GetAllEmployeeQuery, PagedResponse<ResponseEmployeeDto>> {

    private final IGetEmployeeService iGetEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseEmployeeDto> handle(GetAllEmployeeQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        PagedResponse<EmployeeModel> employeeModelPagedResponse = this.iGetEmployeeService.getAll(data);

        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                employeeModelPagedResponse,
                this.iMapperEmployeeApplication::toDto
        );
    }

    @Override
    public Class<GetAllEmployeeQuery> getRequestType() {
        return GetAllEmployeeQuery.class;
    }
}
