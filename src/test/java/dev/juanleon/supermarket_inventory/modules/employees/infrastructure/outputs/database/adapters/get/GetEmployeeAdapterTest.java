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
import org.springframework.data.domain.Page;

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
        )).thenReturn(EmployeeTestData.createPagedResponse(EmployeeTestData.employeeModelList));

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
        )).thenReturn(EmployeeTestData.createPagedResponse(List.of()));

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

        when(this.iEmployeeRepository.findById(EmployeeTestData.employeeId1)).thenReturn(Optional.of(EmployeeTestData.employeeEntity1));

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

        verify(this.iEmployeeRepository).findById(idNoExist);
    }

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetByNameAndLastName() {

        List<EmployeeModel> employeeModelList = List.of(EmployeeTestData.employeeModel1);
        Page<EmployeeEntity> entityPage = EmployeeTestData.createEntityPage(List.of(EmployeeTestData.employeeEntity1));

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findByUserEntity_NameAndUserEntity_LastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.pageable
        )).thenReturn(entityPage);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(entityPage),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(EmployeeTestData.createPagedResponse(employeeModelList));

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getByNameAndLastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(1, response.totalElements());
        assertEquals(employeeModelList, response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);

        verify(this.iEmployeeRepository).findByUserEntity_NameAndUserEntity_LastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.pageable
        );

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(entityPage),
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
        )).thenReturn(EmployeeTestData.createPagedResponse(List.of()));

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

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetByPosition() {

        List<EmployeeModel> employeeModelList = List.of(EmployeeTestData.employeeModel1);

        Page<EmployeeEntity> entityPage = EmployeeTestData.createEntityPage(List.of(EmployeeTestData.employeeEntity1));
        PagedResponse<EmployeeModel> pagedResponse = EmployeeTestData.createPagedResponse(employeeModelList);

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findByPosition(
                EmployeeTestData.employeeModel1.getPosition(),
                EmployeeTestData.pageable
        )).thenReturn(entityPage);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(entityPage),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(pagedResponse);

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getByPosition(
                EmployeeTestData.employeeModel1.getPosition(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(1, response.totalElements());
        assertEquals(employeeModelList, response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);

        verify(this.iEmployeeRepository).findByPosition(
                EmployeeTestData.employeeModel1.getPosition(),
                EmployeeTestData.pageable
        );

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(entityPage),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        );
    }

    @Test
    void shouldReturnPagedResponseEmptyWhenIsCalledMethodGetByPositionWithParamIncorrect() {

        String position = "not exist";

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findByPosition(
                position,
                EmployeeTestData.pageable
        )).thenReturn(EmployeeTestData.pageEmployeeEntityEmpty);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(EmployeeTestData.pageEmployeeEntityEmpty),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(EmployeeTestData.createPagedResponse(List.of()));

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getByPosition(
                position,
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(0, response.totalElements());
        assertEquals(List.of(), response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);

        verify(this.iEmployeeRepository).findByPosition(
                position,
                EmployeeTestData.pageable
        );

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(EmployeeTestData.pageEmployeeEntityEmpty),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        );
    }

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetByHireDate() {

        Page<EmployeeEntity> entityPage = EmployeeTestData.createEntityPage(List.of(EmployeeTestData.employeeEntity2));

        when(this.iMapperPaginationApp.toPageable(EmployeeTestData.paginationRequest)).thenReturn(EmployeeTestData.pageable);

        when(this.iEmployeeRepository.findByHireDateGreaterThanEqual(
                EmployeeTestData.employeeModel2.getHireDate(),
                EmployeeTestData.pageable
        )).thenReturn(entityPage);

        when(this.iMapperPaginationApp.pagetoPagedResponse(
                eq(entityPage),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        )).thenReturn(EmployeeTestData.createPagedResponse(EmployeeTestData.employeeModelList));

        PagedResponse<EmployeeModel> response = this.getEmployeeAdapter.getByHireDate(
                EmployeeTestData.employeeModel2.getHireDate(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(2, response.totalElements());
        assertEquals(EmployeeTestData.employeeModelList, response.content());

        verify(this.iMapperPaginationApp).toPageable(EmployeeTestData.paginationRequest);

        verify(this.iEmployeeRepository).findByHireDateGreaterThanEqual(
                EmployeeTestData.employeeModel2.getHireDate(),
                EmployeeTestData.pageable
        );

        verify(this.iMapperPaginationApp).pagetoPagedResponse(
                eq(entityPage),
                ArgumentMatchers.<Function<EmployeeEntity, EmployeeModel>>any()
        );
    }

    @Test
    void shouldReturnStringWhenIsCalledMethodGetByIdUrlImage() {

        UUID employeeId = EmployeeTestData.employeeId2;

        when(this.iEmployeeRepository.findById(employeeId)).thenReturn(Optional.of(EmployeeTestData.employeeEntity2));

        String response = this.getEmployeeAdapter.getByIdUrlImage(employeeId);

        assertNotNull(response);
        assertEquals(EmployeeTestData.employeeEntity2.getUrlImg(), response);

        verify(this.iEmployeeRepository).findById(employeeId);

    }

    @Test
    void shouldReturnNotFoundEmployeeExceptionWhenIsCalledMethodGetByIdUrlImageWithParamIncorrect() {

        UUID employeeId = UUID.randomUUID();

        when(this.iEmployeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        NotFoundEmployeeException exception = assertThrows(NotFoundEmployeeException.class, () -> {
            this.getEmployeeAdapter.getByIdUrlImage(employeeId);
        });

        String expectedMessage = EMPLOYEE_NOT_FOUND_BY_ID.format(employeeId);
        assertEquals(expectedMessage, exception.getMessage());

        verify(this.iEmployeeRepository).findById(employeeId);

    }
}