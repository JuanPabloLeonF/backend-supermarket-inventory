package dev.juanleon.supermarket_inventory.modules.providers.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.providers.application.handler.update.IUpdateProviderHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateByIdProviderCommandHandler implements IRequestHandler<UpdateByIdProviderCommand, ResponseRequestDto> {

    private final IUpdateProviderHandler iUpdateProviderHandler;

    @Override
    public ResponseRequestDto handle(UpdateByIdProviderCommand request) {
        return this.iUpdateProviderHandler.updateById(request.requestProviderDto(), request.id());
    }

    @Override
    public Class<UpdateByIdProviderCommand> getRequestType() {
        return UpdateByIdProviderCommand.class;
    }
}
