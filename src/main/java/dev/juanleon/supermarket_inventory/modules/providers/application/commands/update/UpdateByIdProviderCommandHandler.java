package dev.juanleon.supermarket_inventory.modules.providers.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.mappers.IMapperProviderApplication;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.update.IUpdateProviderService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateByIdProviderCommandHandler implements IRequestHandler<UpdateByIdProviderCommand, ResponseRequestDto> {

    private final IUpdateProviderService iUpdateProviderService;
    private final IMapperProviderApplication iMapperProviderApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(UpdateByIdProviderCommand request) {
        RequestProviderDto dto = request.requestProviderDto();
        ProviderModel providerModel = this.iMapperProviderApplication.toModel(dto);
        ResponseModel responseModel = this.iUpdateProviderService.updateById(providerModel, request.id());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<UpdateByIdProviderCommand> getRequestType() {
        return UpdateByIdProviderCommand.class;
    }
}
