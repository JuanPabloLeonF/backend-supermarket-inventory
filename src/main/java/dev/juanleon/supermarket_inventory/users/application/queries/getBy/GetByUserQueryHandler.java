package dev.juanleon.supermarket_inventory.users.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.get.IGetUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByUserQueryHandler implements IRequestHandler<GetByIdUserQuery, ResponseUserDto> {

    private final IGetUserHandler iGetUserHandler;

    @Override
    public ResponseUserDto handle(GetByIdUserQuery request) {
        return this.iGetUserHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdUserQuery> getRequestType() {
        return GetByIdUserQuery.class;
    }
}
