package dev.juanleon.supermarket_inventory.modules.providers.application.handler.post;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.mappers.IMapperProviderApplication;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.post.IPostProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostProviderHandler implements IPostProviderHandler {

    private final IPostProviderService iPostProviderService;
    private final IMapperProviderApplication iMapperProviderApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto create(RequestProviderDto requestProviderDto) {
        ProviderModel model = this.iMapperProviderApplication.toModel(requestProviderDto);
        ResponseModel responseModel = this.iPostProviderService.create(model);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
