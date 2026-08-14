package dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.handler.get.IGetProviderHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByNameProviderQueryHandler implements IRequestHandler<GetByNameProviderQuery, ResponseProviderDto> {

    private final IGetProviderHandler iGetProviderHandler;


    @Override
    public ResponseProviderDto handle(GetByNameProviderQuery request) {
        return this.iGetProviderHandler.getByName(request.name());
    }

    @Override
    public Class<GetByNameProviderQuery> getRequestType() {
        return GetByNameProviderQuery.class;
    }
}
