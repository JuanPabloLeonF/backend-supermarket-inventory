package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetEmployeeAdapterTest {

    @Mock
    private IEmployeeRepository iEmployeeRepository;

    @Mock
    private IMapperPaginationApp iMapperPaginationApp;

    @InjectMocks
    private GetEmployeeAdapter getEmployeeAdapter;

    @Test
    void shouldReturnPagedResponseOfEmployeeModel() {

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findAll(EmployeeTestData.pageable)).thenReturn(EmployeeTestData.employeeEntityPage);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(EmployeeTestData.employeeEntityPage),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(EmployeeTestData.employeeModelPageResponse);

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getAll(EmployeeTestData.paginationRequest);

        assertNotNull(response);
        assertEquals(2, response.totalElements());
        assertEquals(EmployeeTestData.employeeModelList, response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);
        verify(this.iEmployeeRepository).findAll(EmployeeTestData.pageable);

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(EmployeeTestData.employeeEntityPage),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        );
    }
}