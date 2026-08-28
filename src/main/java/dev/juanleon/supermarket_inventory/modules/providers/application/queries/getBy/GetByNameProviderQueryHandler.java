package dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.mappers.IMapperProviderApplication;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.get.IGetProviderService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByNameProviderQueryHandler implements IRequestHandler<GetByNameProviderQuery, ResponseProviderDto> {

    private final IGetProviderService iGetProviderService;
    private final IMapperProviderApplication iMapperProviderApplication;

    @Override
    public ResponseProviderDto handle(GetByNameProviderQuery request) {
        return this.iMapperProviderApplication.toDto(this.iGetProviderService.getByName(request.name()));
    }

    @Override
    public Class<GetByNameProviderQuery> getRequestType() {
        return GetByNameProviderQuery.class;
    }
}
