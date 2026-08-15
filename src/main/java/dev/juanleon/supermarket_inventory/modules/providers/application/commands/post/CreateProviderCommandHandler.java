package dev.juanleon.supermarket_inventory.modules.providers.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.providers.application.handler.post.IPostProviderHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProviderCommandHandler implements IRequestHandler<CreateProviderCommand, ResponseRequestDto> {

    private final IPostProviderHandler iPostProviderHandler;

    @Override
    public ResponseRequestDto handle(CreateProviderCommand request) {
        return iPostProviderHandler.create(request.requestProviderDto());
    }

    @Override
    public Class<CreateProviderCommand> getRequestType() {
        return CreateProviderCommand.class;
    }
}
