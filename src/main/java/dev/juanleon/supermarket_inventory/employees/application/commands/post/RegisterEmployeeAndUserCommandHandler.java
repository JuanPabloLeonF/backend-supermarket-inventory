package dev.juanleon.supermarket_inventory.employees.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperInputFileDtoApp;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestRegisterEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.handler.post.IPostEmployeeHandler;
import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
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
