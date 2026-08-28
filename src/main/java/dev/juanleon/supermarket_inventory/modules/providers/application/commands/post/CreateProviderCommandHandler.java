package dev.juanleon.supermarket_inventory.modules.providers.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.mappers.IMapperProviderApplication;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.post.IPostProviderService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateProviderCommandHandler implements IRequestHandler<CreateProviderCommand, ResponseRequestDto> {

    private final IPostProviderService iPostProviderService;
    private final IMapperProviderApplication iMapperProviderApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(CreateProviderCommand request) {
        RequestProviderDto dto = request.requestProviderDto();
        ProviderModel providerModel = this.iMapperProviderApplication.toModel(dto);
        ResponseModel responseModel = this.iPostProviderService.create(providerModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<CreateProviderCommand> getRequestType() {
        return CreateProviderCommand.class;
    }
}
