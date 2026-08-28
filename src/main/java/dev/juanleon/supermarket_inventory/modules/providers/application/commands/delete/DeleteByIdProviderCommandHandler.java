package dev.juanleon.supermarket_inventory.modules.providers.application.commands.delete;

import dev.juanleon.supermarket_inventory.modules.providers.domain.services.delete.IDeleteProviderService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteByIdProviderCommandHandler implements IRequestHandler<DeleteByIdProviderCommand, ResponseRequestDto> {

    private final IDeleteProviderService iDeleteProviderService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(DeleteByIdProviderCommand request) {
        ResponseModel responseModel = this.iDeleteProviderService.deleteById(request.id());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<DeleteByIdProviderCommand> getRequestType() {
        return DeleteByIdProviderCommand.class;
    }
}
