package dev.juanleon.supermarket_inventory.modules.employees.application.handler.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestRegisterEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.post.IPostEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostEmployeeHandler implements IPostEmployeeHandler {

    private final IPostEmployeeService iPostEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto registerEmployeeAndUser(RequestRegisterEmployeeDto requestRegisterEmployeeDto) {
        EmployeeModel employeeModel = this.iMapperEmployeeApplication.toModel(requestRegisterEmployeeDto);
        ResponseModel responseModel = this.iPostEmployeeService.registerEmployeeAndUser(employeeModel, requestRegisterEmployeeDto.getInputFileDto());
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
