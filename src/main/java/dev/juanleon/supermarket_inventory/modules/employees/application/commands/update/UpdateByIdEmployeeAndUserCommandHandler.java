package dev.juanleon.supermarket_inventory.modules.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestUpdateEmployeeAndUser;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.update.IUpdateEmployeeService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateByIdEmployeeAndUserCommandHandler implements IRequestHandler<UpdateByIdEmployeeAndUserCommand, ResponseRequestDto> {

    private final IUpdateEmployeeService iUpdateEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(UpdateByIdEmployeeAndUserCommand request) {
        RequestUpdateEmployeeAndUser dto = request.requestUpdateEmployeeAndUser();
        EmployeeModel employeeModel = this.iMapperEmployeeApplication.toModel(dto);
        ResponseModel responseModel = this.iUpdateEmployeeService.updateByIdEmployeeAndUser(employeeModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<UpdateByIdEmployeeAndUserCommand> getRequestType() {
        return UpdateByIdEmployeeAndUserCommand.class;
    }
}
