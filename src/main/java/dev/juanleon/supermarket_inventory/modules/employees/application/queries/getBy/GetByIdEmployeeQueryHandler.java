package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdEmployeeQueryHandler implements IRequestHandler<GetByIdEmployeeQuery, ResponseEmployeeDto> {

    private final IGetEmployeeService iGetEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;

    @Override
    public ResponseEmployeeDto handle(GetByIdEmployeeQuery request) {
        return this.iMapperEmployeeApplication.toDto(this.iGetEmployeeService.getById(request.id()));
    }

    @Override
    public Class<GetByIdEmployeeQuery> getRequestType() {
        return GetByIdEmployeeQuery.class;
    }
}
