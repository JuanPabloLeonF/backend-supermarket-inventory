package dev.juanleon.supermarket_inventory.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.update.IUpdateEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateByIdEmployeeAndUserCommandHandler implements IRequestHandler<UpdateByIdEmployeeAndUserCommand, ResponseRequestDto> {

    private final IUpdateEmployeeHandler iUpdateEmployeeHandler;

    @Override
    public ResponseRequestDto handle(UpdateByIdEmployeeAndUserCommand request) {
        return this.iUpdateEmployeeHandler.updateByIdEmployeeAndUser(request.requestUpdateEmployeeAndUser());
    }

    @Override
    public Class<UpdateByIdEmployeeAndUserCommand> getRequestType() {
        return UpdateByIdEmployeeAndUserCommand.class;
    }
}
