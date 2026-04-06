package dev.juanleon.supermarket_inventory.employees.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.post.IPostEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterEmployeeAndUserCommandHandler implements IRequestHandler<RegisterEmployeeAndUserCommand, ResponseRequestDto> {

    private final IPostEmployeeHandler iPostEmployeeHandler;

    @Override
    public ResponseRequestDto handle(RegisterEmployeeAndUserCommand request) {
        return this.iPostEmployeeHandler.registerEmployeeAndUser(request.requestEmployeeDto());
    }

    @Override
    public Class<RegisterEmployeeAndUserCommand> getRequestType() {
        return RegisterEmployeeAndUserCommand.class;
    }
}
