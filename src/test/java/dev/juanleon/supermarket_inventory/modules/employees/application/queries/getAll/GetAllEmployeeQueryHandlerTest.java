package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.modules.employees.share.fixtures.EmployeeTestData;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllEmployeeQueryHandlerTest {

    @Mock
    private IGetEmployeeService iGetEmployeeService;

    @Mock
    private IMapperEmployeeApplication iMapperEmployeeApplication;

    @Mock
    private IMapperPaginationApp iMapperPaginationApp;

    @InjectMocks
    private GetAllEmployeeQueryHandler getAllEmployeeQueryHandler;

    @Test
    void shouldReturnPagedResponseOfResponseEmployeeDtoWhenIsCalledMethodHandle() {

        PagedResponse<EmployeeModel> pagedResponse = EmployeeTestData.createPagedResponse(EmployeeTestData.employeeModelList);
        PagedResponse<ResponseEmployeeDto> pagedResponseToDto = EmployeeTestData.createPagedResponseToDto(EmployeeTestData.employeeDtolList);

        when(this.iGetEmployeeService.getAll(EmployeeTestData.paginationRequest))
                .thenReturn(pagedResponse);

        when(this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                eq(pagedResponse),
                ArgumentMatchers.<Function<EmployeeModel, ResponseEmployeeDto>>any()
        )).thenReturn(pagedResponseToDto);

        PagedResponse<ResponseEmployeeDto> result = this.getAllEmployeeQueryHandler.handle(EmployeeTestData.requestGetAllEmployeeQuery);

        assertNotNull(result);
        assertEquals(pagedResponseToDto, result);

        verify(this.iGetEmployeeService).getAll(EmployeeTestData.paginationRequest);

        verify(this.iMapperPaginationApp).pageResponseToPageResponseTypeResponse(
                eq(pagedResponse),
                ArgumentMatchers.<Function<EmployeeModel, ResponseEmployeeDto>>any()
        );
    }

    @Test
    void shouldReturnGetAllEmployeeQueryClassWhenGetRequestTypeIsCalled() {
        Class<GetAllEmployeeQuery> result = this.getAllEmployeeQueryHandler.getRequestType();
        assertEquals(GetAllEmployeeQuery.class, result);
    }

}