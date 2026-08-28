package dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.get;

import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.ISecurityProviderUser;
import dev.juanleon.supermarket_inventory.modules.employees.share.fixtures.EmployeeTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserUseCaseTest {

    @Mock
    private ISecurityProviderUser iSecurityProviderUser;

    @InjectMocks
    private GetUserUseCase getUserUseCase;

    @Test
    void shouldReturnStringTokenWhenIsCalledMethodGeneratedToken() {

        String email = EmployeeTestData.employeeModel1.getUserModel().getEmail();
        String password = EmployeeTestData.employeeModel1.getUserModel().getPassword();
        String token = "eyJhbGciOiJIUzI1NiJ9.test-token";

        when(this.iSecurityProviderUser.generatedToken(email, password)).thenReturn(token);

        String response = this.getUserUseCase.generatedToken(email, password);

        assertNotNull(response);
        assertEquals(token, response);

        verify(this.iSecurityProviderUser).generatedToken(email, password);
    }
}