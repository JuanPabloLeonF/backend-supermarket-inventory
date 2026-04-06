package dev.juanleon.supermarket_inventory.employees.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.employees.application.dto.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetEmployeeHandler implements IGetEmployeeHandler {

    private final IGetEmployeeService iGetEmployeeService;
    private final IMapperEmployeeApplication iMapperEmployeeApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<ResponseEmployeeDto> getAll(PaginationRequest paginationRequest) {
        PagedResponse<EmployeeModel> employeeModelPagedResponse = this.iGetEmployeeService.getAll(paginationRequest);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        employeeModelPagedResponse,
                        this.iMapperEmployeeApplication::toDto
                );
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEmployeeDto getById(UUID id) {
        return this.iMapperEmployeeApplication
                .toDto(this.iGetEmployeeService.getById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<ResponseEmployeeDto> getByNameAndLastName(String name, String lastName, PaginationRequest paginationRequest) {
        PagedResponse<EmployeeModel> employeeModelPagedResponse = this.iGetEmployeeService.getByNameAndLastName(name, lastName, paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(employeeModelPagedResponse, this.iMapperEmployeeApplication::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<ResponseEmployeeDto> getByPosition(String position, PaginationRequest paginationRequest) {
        PagedResponse<EmployeeModel> employeeModelPagedResponse = this.iGetEmployeeService.getByPosition(position, paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(employeeModelPagedResponse, this.iMapperEmployeeApplication::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<ResponseEmployeeDto> getByHireDate(LocalDateTime hireDate, PaginationRequest paginationRequest) {
        PagedResponse<EmployeeModel> employeeModelPagedResponse = this.iGetEmployeeService.getByHireDate(hireDate, paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(employeeModelPagedResponse, this.iMapperEmployeeApplication::toDto);
    }
}
