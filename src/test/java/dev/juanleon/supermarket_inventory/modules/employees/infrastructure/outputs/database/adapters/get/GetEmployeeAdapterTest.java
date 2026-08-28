package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import dev.juanleon.supermarket_inventory.modules.employees.share.fixtures.EmployeeTestData;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.EMPLOYEE_NOT_FOUND_BY_ID;
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

    @Mock
    private IMapperEmployeeInfrastructure iMapperEmployeeInfrastructure;

    @InjectMocks
    private GetEmployeeAdapter getEmployeeAdapter;

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetAll() {

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

    @Test
    void shouldReturnPagedResponseEmptyWhenIsCalledMethodGetAll() {

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findAll(EmployeeTestData.pageable)).thenReturn(EmployeeTestData.pageEmployeeEntityEmpty);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(EmployeeTestData.pageEmployeeEntityEmpty),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(EmployeeTestData.employeeModelPageResponseEmpty);

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getAll(EmployeeTestData.paginationRequest);

        assertNotNull(response);
        assertEquals(0, response.totalElements());
        assertEquals(List.of(), response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);
        verify(this.iEmployeeRepository).findAll(EmployeeTestData.pageable);

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(EmployeeTestData.pageEmployeeEntityEmpty),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        );
    }

    @Test
    void shouldReturnEmployeeModelWhenIsCalledMethodGetById() {

        when(this.iEmployeeRepository.findById(EmployeeTestData.employeeId1)).thenReturn(Optional.ofNullable(EmployeeTestData.employeeEntity1));

        when(this.iMapperEmployeeInfrastructure.toModel(EmployeeTestData.employeeEntity1)).thenReturn(EmployeeTestData.employeeModel1);

        EmployeeModel result = this.getEmployeeAdapter.getById(EmployeeTestData.employeeId1);

        assertNotNull(result);
        assertEquals(EmployeeTestData.employeeId1, result.getId());

        verify(this.iEmployeeRepository).findById(EmployeeTestData.employeeId1);
        verify(this.iMapperEmployeeInfrastructure).toModel(EmployeeTestData.employeeEntity1);
    }

    @Test
    void shouldReturnNotFoundEmployeeExceptionWhenIsCalledMethodGetByIdWithParamIncorrect() {

        UUID idNoExist = UUID.randomUUID();

        when(this.iEmployeeRepository.findById(idNoExist)).thenReturn(Optional.empty());

        NotFoundEmployeeException exception = assertThrows(NotFoundEmployeeException.class, () -> {
            this.getEmployeeAdapter.getById(idNoExist);
        });

        String expectedMessage = EMPLOYEE_NOT_FOUND_BY_ID.format(idNoExist);
        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(NotFoundEmployeeException.class, exception.getClass());

        verify(this.iEmployeeRepository).findById(idNoExist);
    }

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetByNameAndLastName() {

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findByUserEntity_NameAndUserEntity_LastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.pageable
        )).thenReturn(EmployeeTestData.employeeEntityPageForNameAndLastName);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(EmployeeTestData.employeeEntityPageForNameAndLastName),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(EmployeeTestData.employeeModelPageResponseForNameAndLastName);

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getByNameAndLastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(1, response.totalElements());
        assertEquals(EmployeeTestData.employeeModelListForNameAndLastName, response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);

        verify(this.iEmployeeRepository).findByUserEntity_NameAndUserEntity_LastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.pageable
        );

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(EmployeeTestData.employeeEntityPageForNameAndLastName),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        );
    }

    @Test
    void shouldReturnPagedResponseEmptyWhenIsCalledMethodGetByNameAndLastNameWithParamsIncorrect() {

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findByUserEntity_NameAndUserEntity_LastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.pageable
        )).thenReturn(EmployeeTestData.pageEmployeeEntityEmpty);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(EmployeeTestData.pageEmployeeEntityEmpty),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(EmployeeTestData.employeeModelPageResponseEmpty);

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getByNameAndLastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(0, response.totalElements());
        assertEquals(List.of(), response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);

        verify(this.iEmployeeRepository).findByUserEntity_NameAndUserEntity_LastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.pageable
        );

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(EmployeeTestData.pageEmployeeEntityEmpty),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        );
    }
}