package dev.juanleon.supermarket_inventory.users.application.queries.getBy;

import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.get.IGetUserHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetByLastNameUserQueryHandlerTest {

    @Mock
    private IGetUserHandler iGetUserHandler;

    @InjectMocks
    private GetByLastNameUserQueryHandler getByLastNameUserQueryHandler;

    protected String lastName = "leon";

    protected GetByLastNameUserQuery getByLastNameUserQuery = new GetByLastNameUserQuery(lastName);
    protected List<ResponseUserDto> responseUserDtoList;

    protected UUID id1 = UUID.randomUUID();
    protected UUID id2 = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        this.responseUserDtoList = List.of(
                new ResponseUserDto(this.id1, "juan", "leon", "juan123@gmail.com", "1234567", "ADMIN", true, LocalDateTime.now(), LocalDateTime.now()),
                new ResponseUserDto(this.id2, "pipe", "leon", "pipe123@gmail.com", "123456789", "USER", false, LocalDateTime.now(), LocalDateTime.now())
        );
    }

    @Test
    void shouldReturnListResponseUserWhenHandleIsCalledMethoGetByLastNameWithParamLastName() {

        when(this.iGetUserHandler.getByLastName(this.lastName))
                .thenReturn(this.responseUserDtoList);

        List<ResponseUserDto> response = this.getByLastNameUserQueryHandler
                .handle(this.getByLastNameUserQuery);

        assertNotNull(response);
        assertEquals(this.responseUserDtoList, response);

        verify(this.iGetUserHandler).getByLastName(this.lastName);

    }

    @Test
    void shouldReturnListEmptyWhenHandleIsCalledGetByLastNameWithParamNoExistisOrNull() {

        String lastNameNoExistis = "no existe";

        when(this.iGetUserHandler.getByLastName(lastNameNoExistis))
                .thenReturn(Collections.emptyList());

        List<ResponseUserDto> response = this.getByLastNameUserQueryHandler
                .handle(new GetByLastNameUserQuery(lastNameNoExistis));

        assertTrue(response.isEmpty());

        verify(this.iGetUserHandler).getByLastName(lastNameNoExistis);

    }

    @Test
    void shouldReturnCorrectRequestType() {
        Class<GetByLastNameUserQuery> result = this.getByLastNameUserQueryHandler.getRequestType();
        assertEquals(GetByLastNameUserQuery.class, result);
    }
}