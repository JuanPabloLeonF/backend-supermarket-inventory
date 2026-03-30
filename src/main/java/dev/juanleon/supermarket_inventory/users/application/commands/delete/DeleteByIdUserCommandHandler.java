package dev.juanleon.supermarket_inventory.users.application.commands.delete;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.handler.delete.IDeleteUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdUserCommandHandler implements IRequestHandler<DeleteByIdUserCommand, ResponseRequestDto> {

    private final IDeleteUserHandler iDeleteUserHandler;

    @Override
    public ResponseRequestDto handle(DeleteByIdUserCommand request) {
        return this.iDeleteUserHandler.deleteById(request.id());
    }

    @Override
    public Class<DeleteByIdUserCommand> getRequestType() {
        return DeleteByIdUserCommand.class;
    }
}
