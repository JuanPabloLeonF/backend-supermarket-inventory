package dev.juanleon.supermarket_inventory.users.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.handler.post.IPostUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserCommandHandler implements IRequestHandler<CreateUserCommand, ResponseRequestDto> {

    private final IPostUserHandler iPostUserHandler;

    @Override
    public ResponseRequestDto handle(CreateUserCommand request) {
        return this.iPostUserHandler.create(request.requestUserDto());
    }

    @Override
    public Class<CreateUserCommand> getRequestType() {
        return CreateUserCommand.class;
    }
}
