package dev.juanleon.supermarket_inventory.modules.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.employees.domain.services.update.IUpdateEmployeeService;
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
public class UpdateByIdImgCommandHandler implements IRequestHandler<UpdateByIdImgCommand, ResponseRequestDto> {

    private final IUpdateEmployeeService iUpdateEmployeeService;
    private final IMapperInputFileDtoApp iMapperInputFileDtoApp;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(UpdateByIdImgCommand request) {
        InputFileDto dto = this.iMapperInputFileDtoApp.toDto(request.fileImg());
        ResponseModel responseModel = this.iUpdateEmployeeService.updateByIdImage(request.id(), dto);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<UpdateByIdImgCommand> getRequestType() {
        return UpdateByIdImgCommand.class;
    }
}
