package dev.juanleon.supermarket_inventory.modules.products.application.commands.update;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.products.application.handler.update.IUpdateProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateActivateProductCommandHandler implements IRequestHandler<UpdateActivateProductCommand, ResponseRequestDto> {

    private final IUpdateProductHandler iUpdateProductHandler;

    @Override
    public ResponseRequestDto handle(UpdateActivateProductCommand request) {
        return this.iUpdateProductHandler.updateActive(
                request.requestProductUpdateActivateDto().getProductId(),
                request.requestProductUpdateActivateDto().getActive()
        );
    }

    @Override
    public Class<UpdateActivateProductCommand> getRequestType() {
        return UpdateActivateProductCommand.class;
    }
}
