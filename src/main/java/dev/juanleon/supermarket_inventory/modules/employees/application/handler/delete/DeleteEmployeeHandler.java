package dev.juanleon.supermarket_inventory.modules.employees.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.delete.IDeleteEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteEmployeeHandler implements IDeleteEmployeeHandler {

    private final IDeleteEmployeeService iDeleteEmployeeService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto deleteEmployeeAndUser(UUID idEmployee) {
        ResponseModel responseModel = this.iDeleteEmployeeService.deleteEmployeeAndUser(idEmployee);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
