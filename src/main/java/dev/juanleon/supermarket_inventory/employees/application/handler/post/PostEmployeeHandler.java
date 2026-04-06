package dev.juanleon.supermarket_inventory.employees.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.files.IFileUtils;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.employees.application.dto.RequestEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.services.post.IPostEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostEmployeeHandler implements IPostEmployeeHandler {

    private final IPostEmployeeService iPostEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperResponseApp iMapperResponseApp;
    private final IFileUtils iFileUtils;

    @Override
    @Transactional
    public ResponseRequestDto registerEmployeeAndUser(RequestEmployeeDto requestEmployeeDto) {
        String path = this.iFileUtils.saveFile(requestEmployeeDto.getImgFile());
        EmployeeModel employeeModel = this.iMapperEmployeeApplication.toModel(requestEmployeeDto);
        employeeModel.setUrlImg(path);
        ResponseModel responseModel = this.iPostEmployeeService.registerEmployeeAndUser(employeeModel);
        return this.iMapperResponseApp.toResponseRequestDto(responseModel);
    }
}
