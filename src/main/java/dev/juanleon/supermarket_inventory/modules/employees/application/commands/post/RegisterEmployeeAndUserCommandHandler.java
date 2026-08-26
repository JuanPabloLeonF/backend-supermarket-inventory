package dev.juanleon.supermarket_inventory.modules.employees.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.post.IPostEmployeeService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestRegisterEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterEmployeeAndUserCommandHandler implements IRequestHandler<RegisterEmployeeAndUserCommand, ResponseRequestDto> {

    private final IPostEmployeeService iPostEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(RegisterEmployeeAndUserCommand request) {
        RequestRegisterEmployeeDto dto = this.iMapperEmployeeApplication.toDto(request.requestEmployeeDto());
        EmployeeModel employeeModel = this.iMapperEmployeeApplication.toModel(dto);
        ResponseModel responseModel = this.iPostEmployeeService.registerEmployeeAndUser(employeeModel, dto.getInputFileDto());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<RegisterEmployeeAndUserCommand> getRequestType() {
        return RegisterEmployeeAndUserCommand.class;
    }
}
