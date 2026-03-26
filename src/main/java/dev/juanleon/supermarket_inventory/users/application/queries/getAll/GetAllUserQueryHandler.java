package dev.juanleon.supermarket_inventory.users.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.get.IGetUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUserQueryHandler implements IRequestHandler<GetAllUserQuery, List<ResponseUserDto>> {

    private final IGetUserHandler iGetUserHandler;

    @Override
    public List<ResponseUserDto> handle(GetAllUserQuery request) {
        return this.iGetUserHandler.getAll();
    }

    @Override
    public Class<GetAllUserQuery> getRequestType() {
        return GetAllUserQuery.class;
    }
}
