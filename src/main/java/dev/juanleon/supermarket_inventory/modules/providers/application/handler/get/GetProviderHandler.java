package dev.juanleon.supermarket_inventory.modules.providers.application.handler.get;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.mappers.IMapperProviderApplication;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.get.IGetProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetProviderHandler implements IGetProviderHandler {

    private final IGetProviderService iGetProviderService;
    private final IMapperProviderApplication  iMapperProviderApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public ResponseProviderDto getById(UUID id) {
        return this.iMapperProviderApplication.toDto(this.iGetProviderService.getById(id));
    }

    @Override
    public ResponseProviderDto getByName(String name) {
        return this.iMapperProviderApplication.toDto(this.iGetProviderService.getByName(name));
    }

    @Override
    public PagedResponse<ResponseProviderDto> getAll(PaginationRequest paginationRequest) {
        PagedResponse<ProviderModel> modelPagedResponse = this.iGetProviderService.getAll(paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                modelPagedResponse,
                this.iMapperProviderApplication::toDto
        );
    }
}
