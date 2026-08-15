package dev.juanleon.supermarket_inventory.modules.providers.application.handler.delete;

import dev.juanleon.supermarket_inventory.modules.providers.domain.services.delete.IDeleteProviderService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteProviderHandler implements IDeleteProviderHandler {

    private final IDeleteProviderService iDeleteProviderService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto deleteById(UUID id) {
        ResponseModel responseModel = this.iDeleteProviderService.deleteById(id);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
