package dev.juanleon.supermarket_inventory.users.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.get.IGetUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetByNameUserQueryHandler implements IRequestHandler<GetByNameUserQuery, List<ResponseUserDto>> {

    private final IGetUserHandler iGetUserHandler;

    @Override
    public List<ResponseUserDto> handle(GetByNameUserQuery request) {
        return this.iGetUserHandler.getByName(request.name());
    }

    @Override
    public Class<GetByNameUserQuery> getRequestType() {
        return GetByNameUserQuery.class;
    }
}
