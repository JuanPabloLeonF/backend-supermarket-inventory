package dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.get;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.share.fixtures.EmployeeTestData;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetEmployeeUseCaseTest {

    @Mock
    private IGetEmployeePersistence iGetEmployeePersistence;

    @InjectMocks
    private GetEmployeeUseCase getEmployeeUseCase;

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetAll() {

        when(this.iGetEmployeePersistence.getAll(EmployeeTestData.paginationRequest)).thenReturn(
                EmployeeTestData.createPagedResponse(List.of(EmployeeTestData.employeeModel1, EmployeeTestData.employeeModel2))
        );

        PagedResponse<EmployeeModel> response = this.getEmployeeUseCase.getAll(EmployeeTestData.paginationRequest);

        assertNotNull(response);
        assertEquals(EmployeeTestData.employeeModelList, response.content());

        verify(this.iGetEmployeePersistence).getAll(EmployeeTestData.paginationRequest);

    }

    @Test
    void shouldReturnEmployeeModelWhenIsCalledMethodGetById() {

        UUID employeeId = EmployeeTestData.employeeId2;

        when(this.iGetEmployeePersistence.getById(employeeId)).thenReturn(EmployeeTestData.employeeModel2);

        EmployeeModel response = this.getEmployeeUseCase.getById(employeeId);

        assertNotNull(response);
        assertEquals(EmployeeTestData.employeeModel2, response);

        verify(this.iGetEmployeePersistence).getById(employeeId);

    }

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetByNameAndLastName() {

        List<EmployeeModel> employeeModelList = List.of(EmployeeTestData.employeeModel1);

        when(this.iGetEmployeePersistence.getByNameAndLastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.paginationRequest
        )).thenReturn(
                EmployeeTestData.createPagedResponse(employeeModelList)
        );

        PagedResponse<EmployeeModel> response = this.getEmployeeUseCase.getByNameAndLastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(employeeModelList, response.content());

        verify(this.iGetEmployeePersistence).getByNameAndLastName(
                EmployeeTestData.employeeModel1.getUserModel().getName(),
                EmployeeTestData.employeeModel1.getUserModel().getLastName(),
                EmployeeTestData.paginationRequest
        );

    }

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetByPosition() {

        List<EmployeeModel> employeeModelList = List.of(EmployeeTestData.employeeModel2);

        when(this.iGetEmployeePersistence.getByPosition(
                EmployeeTestData.employeeModel2.getPosition(),
                EmployeeTestData.paginationRequest
        )).thenReturn(
                EmployeeTestData.createPagedResponse(employeeModelList)
        );

        PagedResponse<EmployeeModel> response = this.getEmployeeUseCase.getByPosition(
                EmployeeTestData.employeeModel2.getPosition(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(employeeModelList, response.content());

        verify(this.iGetEmployeePersistence).getByPosition(
                EmployeeTestData.employeeModel2.getPosition(),
                EmployeeTestData.paginationRequest
        );

    }

    @Test
    void shouldReturnPagedResponseOfEmployeeModelWhenIsCalledMethodGetByHireDate() {

        when(this.iGetEmployeePersistence.getByHireDate(
                EmployeeTestData.employeeModel2.getHireDate(),
                EmployeeTestData.paginationRequest
        )).thenReturn(
                EmployeeTestData.createPagedResponse(EmployeeTestData.employeeModelList)
        );

        PagedResponse<EmployeeModel> response = this.getEmployeeUseCase.getByHireDate(
                EmployeeTestData.employeeModel2.getHireDate(),
                EmployeeTestData.paginationRequest
        );

        assertNotNull(response);
        assertEquals(EmployeeTestData.employeeModelList, response.content());

        verify(this.iGetEmployeePersistence).getByHireDate(
                EmployeeTestData.employeeModel2.getHireDate(),
                EmployeeTestData.paginationRequest
        );

    }

    @Test
    void shouldReturnStringWhenIsCalledMethodGetByIdUrlImage() {

        UUID employeeId = EmployeeTestData.employeeId2;

        when(this.iGetEmployeePersistence.getByIdUrlImage(employeeId)).thenReturn(EmployeeTestData.employeeModel2.getUrlImg());

        String response = this.getEmployeeUseCase.getByIdUrlImage(employeeId);

        assertNotNull(response);
        assertEquals(EmployeeTestData.employeeModel2.getUrlImg(), response);

        verify(this.iGetEmployeePersistence).getByIdUrlImage(employeeId);

    }
}