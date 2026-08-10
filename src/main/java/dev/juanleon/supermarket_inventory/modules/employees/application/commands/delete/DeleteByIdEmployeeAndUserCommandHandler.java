package dev.juanleon.supermarket_inventory.modules.employees.application.commands.delete;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.handler.delete.IDeleteEmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdEmployeeAndUserCommandHandler implements IRequestHandler<DeleteByIdEmployeeAndUserCommand, ResponseRequestDto> {

    private final IDeleteEmployeeHandler iDeleteEmployeeHandler;

    @Override
    public ResponseRequestDto handle(DeleteByIdEmployeeAndUserCommand request) {
        return this.iDeleteEmployeeHandler.deleteEmployeeAndUser(request.idEmployee());
    }

    @Override
    public Class<DeleteByIdEmployeeAndUserCommand> getRequestType() {
        return DeleteByIdEmployeeAndUserCommand.class;
    }
}
