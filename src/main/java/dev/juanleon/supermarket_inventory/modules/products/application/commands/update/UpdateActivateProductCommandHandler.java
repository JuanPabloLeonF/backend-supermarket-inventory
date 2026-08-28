package dev.juanleon.supermarket_inventory.modules.products.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.products.domain.services.update.IUpdateProductService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateActivateProductCommandHandler implements IRequestHandler<UpdateActivateProductCommand, ResponseRequestDto> {

    private final IUpdateProductService iUpdateProductService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(UpdateActivateProductCommand request) {
        ResponseModel responseModel = this.iUpdateProductService.updateActive(
                request.requestProductUpdateActivateDto().getProductId(),
                request.requestProductUpdateActivateDto().getActive()
        );
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<UpdateActivateProductCommand> getRequestType() {
        return UpdateActivateProductCommand.class;
    }
}
