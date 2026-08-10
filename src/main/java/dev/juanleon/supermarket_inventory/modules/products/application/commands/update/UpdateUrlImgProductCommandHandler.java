package dev.juanleon.supermarket_inventory.modules.products.application.commands.update;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperInputFileDtoApp;
import dev.juanleon.supermarket_inventory.modules.products.application.handler.update.IUpdateProductHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUrlImgProductCommandHandler implements IRequestHandler<UpdateUrlImgProductCommand, ResponseRequestDto> {

    private final IUpdateProductHandler iUpdateProductHandler;
    private final IMapperInputFileDtoApp iMapperInputFileDtoApp;

    @Override
    public ResponseRequestDto handle(UpdateUrlImgProductCommand request) {
        InputFileDto inputFileDto = this.iMapperInputFileDtoApp.toDto(request.requestProductUpdateUrlImgDto().getImgFile());
        return this.iUpdateProductHandler.updateUrlImg(
                request.requestProductUpdateUrlImgDto().getProductId(),
                inputFileDto
        );
    }

    @Override
    public Class<UpdateUrlImgProductCommand> getRequestType() {
        return UpdateUrlImgProductCommand.class;
    }
}
