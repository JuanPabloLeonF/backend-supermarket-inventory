package dev.juanleon.supermarket_inventory.employees.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.files.IFileUtils;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestUpdateEmployeeAndUser;
import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.update.IUpdateEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateEmployeeHandler implements IUpdateEmployeeHandler {

    private final IUpdateEmployeeService iUpdateEmployeeService;
    private final IGetEmployeePersistence iGetEmployeePersistence;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperResponseApp iMapperResponseApp;
    private final IFileUtils iFileUtils;

    @Override
    @Transactional
    public ResponseRequestDto updateByIdEmployeeAndUser(RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser) {
        EmployeeModel employeeModel = this.iMapperEmployeeApplication.toModel(requestUpdateEmployeeAndUser);
        ResponseModel responseModel = this.iUpdateEmployeeService.updateByIdEmployeeAndUser(employeeModel);
        return this.iMapperResponseApp.toResponseRequestDto(responseModel);
    }

    @Override
    @Transactional
    public ResponseRequestDto updateByIdImage(MultipartFile fileImg, UUID id) {
        String urlImgFound = this.iGetEmployeePersistence.getByIdUrlImage(id);
        String urlImg = this.iFileUtils.updateFileExisting(fileImg, urlImgFound);
        ResponseModel responseModel = this.iUpdateEmployeeService.updateByIdImage(urlImg, id);
        return this.iMapperResponseApp.toResponseRequestDto(responseModel);
    }
}
