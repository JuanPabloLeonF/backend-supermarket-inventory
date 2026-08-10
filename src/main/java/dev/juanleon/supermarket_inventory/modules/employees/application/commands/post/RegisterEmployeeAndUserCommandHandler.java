package dev.juanleon.supermarket_inventory.modules.employees.application.commands.post;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestRegisterEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.handler.post.IPostEmployeeHandler;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterEmployeeAndUserCommandHandler implements IRequestHandler<RegisterEmployeeAndUserCommand, ResponseRequestDto> {

    private final IPostEmployeeHandler iPostEmployeeHandler;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;

    @Override
    public ResponseRequestDto handle(RegisterEmployeeAndUserCommand request) {
        RequestRegisterEmployeeDto dto = this.iMapperEmployeeApplication.toDto(request.requestEmployeeDto());
        return this.iPostEmployeeHandler.registerEmployeeAndUser(dto);
    }

    @Override
    public Class<RegisterEmployeeAndUserCommand> getRequestType() {
        return RegisterEmployeeAndUserCommand.class;
    }
}
