package dev.juanleon.supermarket_inventory.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperInputFileDtoApp;
import dev.juanleon.supermarket_inventory.employees.application.handler.update.IUpdateEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateByIdImgCommandHandler implements IRequestHandler<UpdateByIdImgCommand, ResponseRequestDto> {

    private final IUpdateEmployeeHandler iUpdateEmployeeHandler;
    private final IMapperInputFileDtoApp iMapperInputFileDtoApp;

    @Override
    public ResponseRequestDto handle(UpdateByIdImgCommand request) {
        InputFileDto dto = this.iMapperInputFileDtoApp.toDto(request.fileImg());
        return this.iUpdateEmployeeHandler.updateByIdImage(dto, request.id());
    }

    @Override
    public Class<UpdateByIdImgCommand> getRequestType() {
        return UpdateByIdImgCommand.class;
    }
}
