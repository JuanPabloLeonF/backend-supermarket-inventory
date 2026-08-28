package dev.juanleon.supermarket_inventory.modules.products.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.products.domain.services.update.IUpdateProductService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperInputFileDtoApp;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUrlImgProductCommandHandler implements IRequestHandler<UpdateUrlImgProductCommand, ResponseRequestDto> {

    private final IUpdateProductService iUpdateProductService;
    private final IMapperInputFileDtoApp iMapperInputFileDtoApp;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(UpdateUrlImgProductCommand request) {
        InputFileDto inputFileDto = this.iMapperInputFileDtoApp.toDto(request.requestProductUpdateUrlImgDto().getImgFile());
        ResponseModel responseModel = this.iUpdateProductService.updateUrlImg(
                request.requestProductUpdateUrlImgDto().getProductId(),
                inputFileDto
        );
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<UpdateUrlImgProductCommand> getRequestType() {
        return UpdateUrlImgProductCommand.class;
    }
}
