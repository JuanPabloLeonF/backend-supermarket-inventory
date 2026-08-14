package dev.juanleon.supermarket_inventory.modules.providers.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.handler.get.IGetProviderHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllProviderQueryHandler implements IRequestHandler<GetAllProviderQuery, PagedResponse<ResponseProviderDto>> {

    private final IGetProviderHandler iGetProviderHandler;

    @Override
    public PagedResponse<ResponseProviderDto> handle(GetAllProviderQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetProviderHandler.getAll(data);
    }

    @Override
    public Class<GetAllProviderQuery> getRequestType() {
        return GetAllProviderQuery.class;
    }
}
