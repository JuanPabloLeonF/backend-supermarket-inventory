package dev.juanleon.supermarket_inventory.modules.employees.application.commands.delete;

import dev.juanleon.supermarket_inventory.modules.employees.domain.services.delete.IDeleteEmployeeService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteByIdEmployeeAndUserCommandHandler implements IRequestHandler<DeleteByIdEmployeeAndUserCommand, ResponseRequestDto> {

    private final IDeleteEmployeeService iDeleteEmployeeService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(DeleteByIdEmployeeAndUserCommand request) {
        ResponseModel responseModel = this.iDeleteEmployeeService.deleteEmployeeAndUser(request.idEmployee());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<DeleteByIdEmployeeAndUserCommand> getRequestType() {
        return DeleteByIdEmployeeAndUserCommand.class;
    }
}
