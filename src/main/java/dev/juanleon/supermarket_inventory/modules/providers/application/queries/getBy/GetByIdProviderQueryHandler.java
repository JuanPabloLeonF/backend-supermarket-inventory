package dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.handler.get.IGetProviderHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdProviderQueryHandler implements IRequestHandler<GetByIdProviderQuery, ResponseProviderDto> {

    private final IGetProviderHandler iGetProviderHandler;


    @Override
    public ResponseProviderDto handle(GetByIdProviderQuery request) {
        return this.iGetProviderHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdProviderQuery> getRequestType() {
        return GetByIdProviderQuery.class;
    }
}
