package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.handler.get.IGetEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdEmployeeQueryHandler implements IRequestHandler<GetByIdEmployeeQuery, ResponseEmployeeDto> {

    private final IGetEmployeeHandler iGetEmployeeHandler;

    @Override
    public ResponseEmployeeDto handle(GetByIdEmployeeQuery request) {
        return this.iGetEmployeeHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdEmployeeQuery> getRequestType() {
        return GetByIdEmployeeQuery.class;
    }
}
