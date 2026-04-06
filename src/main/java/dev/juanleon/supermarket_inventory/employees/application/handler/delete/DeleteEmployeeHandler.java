package dev.juanleon.supermarket_inventory.employees.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.employees.domain.services.delete.IDeleteEmployeeService;
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
    public ResponseRequestDto deleteEmployeeAndUser(UUID idEmployee, UUID idUser) {
        ResponseModel responseModel = this.iDeleteEmployeeService.deleteEmployeeAndUser(idEmployee, idUser);
        return this.iMapperResponseApp.toResponseRequestDto(responseModel);
    }
}
