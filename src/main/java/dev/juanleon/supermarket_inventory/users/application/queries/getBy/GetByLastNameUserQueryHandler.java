package dev.juanleon.supermarket_inventory.users.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.get.IGetUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetByLastNameUserQueryHandler implements IRequestHandler<GetByLastNameUserQuery, List<ResponseUserDto>> {

    private final IGetUserHandler iGetUserHandler;

    @Override
    public List<ResponseUserDto> handle(GetByLastNameUserQuery request) {
        return this.iGetUserHandler.getByLastName(request.lastName());
    }

    @Override
    public Class<GetByLastNameUserQuery> getRequestType() {
        return GetByLastNameUserQuery.class;
    }
}
