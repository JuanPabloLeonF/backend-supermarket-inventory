package dev.juanleon.supermarket_inventory.modules.employees.application.handler.update;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestUpdateEmployeeAndUser;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.update.IUpdateEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeHandler implements IUpdateEmployeeHandler {

    private final IUpdateEmployeeService iUpdateEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto updateByIdEmployeeAndUser(RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser) {
        EmployeeModel employeeModel = this.iMapperEmployeeApplication.toModel(requestUpdateEmployeeAndUser);
        ResponseModel responseModel = this.iUpdateEmployeeService.updateByIdEmployeeAndUser(employeeModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    @Transactional
    public ResponseRequestDto updateByIdImage(InputFileDto inputFileDto, UUID id) {
        ResponseModel responseModel = this.iUpdateEmployeeService.updateByIdImage(id, inputFileDto);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
