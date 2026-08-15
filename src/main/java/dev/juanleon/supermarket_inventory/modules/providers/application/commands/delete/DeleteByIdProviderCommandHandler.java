package dev.juanleon.supermarket_inventory.modules.providers.application.commands.delete;

import dev.juanleon.supermarket_inventory.modules.providers.application.handler.delete.IDeleteProviderHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdProviderCommandHandler implements IRequestHandler<DeleteByIdProviderCommand, ResponseRequestDto> {

    private final IDeleteProviderHandler iDeleteProviderHandler;

    @Override
    public ResponseRequestDto handle(DeleteByIdProviderCommand request) {
        return this.iDeleteProviderHandler.deleteById(request.id());
    }

    @Override
    public Class<DeleteByIdProviderCommand> getRequestType() {
        return DeleteByIdProviderCommand.class;
    }
}
