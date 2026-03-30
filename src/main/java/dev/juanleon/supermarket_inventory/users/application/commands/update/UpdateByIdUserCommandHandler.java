package dev.juanleon.supermarket_inventory.users.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.handler.update.IUpdateUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateByIdUserCommandHandler implements IRequestHandler<UpdateByIdUserCommand, ResponseRequestDto> {

    private final IUpdateUserHandler iUpdateUserHandler;

    @Override
    public ResponseRequestDto handle(UpdateByIdUserCommand request) {
        return this.iUpdateUserHandler.updateById(request.requestUpdateUserDto());
    }

    @Override
    public Class<UpdateByIdUserCommand> getRequestType() {
        return UpdateByIdUserCommand.class;
    }
}
