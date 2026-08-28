package dev.juanleon.supermarket_inventory.modules.providers.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.mappers.IMapperProviderApplication;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.get.IGetProviderService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllProviderQueryHandler implements IRequestHandler<GetAllProviderQuery, PagedResponse<ResponseProviderDto>> {

    private final IGetProviderService iGetProviderService;
    private final IMapperProviderApplication iMapperProviderApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseProviderDto> handle(GetAllProviderQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        PagedResponse<ProviderModel> modelPagedResponse = this.iGetProviderService.getAll(data);

        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                modelPagedResponse,
                this.iMapperProviderApplication::toDto
        );
    }

    @Override
    public Class<GetAllProviderQuery> getRequestType() {
        return GetAllProviderQuery.class;
    }
}
