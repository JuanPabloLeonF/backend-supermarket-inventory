package dev.juanleon.supermarket_inventory.modules.providers.application.handler.update;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.mappers.IMapperProviderApplication;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.update.IUpdateProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateProviderHandler implements IUpdateProviderHandler {

    private final IUpdateProviderService iUpdateProviderService;
    private final IMapperProviderApplication iMapperProviderApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto updateById(RequestProviderDto requestProviderDto, UUID id) {
        ProviderModel model = this.iMapperProviderApplication.toModel(requestProviderDto);
        ResponseModel responseModel = this.iUpdateProviderService.updateById(model, id);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
