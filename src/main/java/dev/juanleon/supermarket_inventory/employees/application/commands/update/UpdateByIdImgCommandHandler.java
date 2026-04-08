package dev.juanleon.supermarket_inventory.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.update.IUpdateEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateByIdImgCommandHandler implements IRequestHandler<UpdateByIdImgCommand, ResponseRequestDto> {

    private final IUpdateEmployeeHandler iUpdateEmployeeHandler;

    @Override
    public ResponseRequestDto handle(UpdateByIdImgCommand request) {
        return this.iUpdateEmployeeHandler.updateByIdImage(request.fileImg(), request.id());
    }

    @Override
    public Class<UpdateByIdImgCommand> getRequestType() {
        return UpdateByIdImgCommand.class;
    }
}
