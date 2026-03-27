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
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetByNameUserQueryHandlerTest {

    @Mock
    private IGetUserHandler iGetUserHandler;

    @InjectMocks
    private GetByNameUserQueryHandler getByNameUserQueryHandler;

    protected String name = "pipe";

    protected GetByNameUserQuery getByNameUserQuery = new GetByNameUserQuery(name);
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
    void shouldReturnListResponseUserWhenHandleIsCalledMethoGetByNameWithParamName() {

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter(user -> Objects.equals(user.getName(), this.name))
                .toList();

        when(this.iGetUserHandler.getByName(this.name))
                .thenReturn(userDtoList);

        List<ResponseUserDto> response = this.getByNameUserQueryHandler.handle(this.getByNameUserQuery);

        assertNotNull(response);
        assertEquals(userDtoList, response);

        verify(this.iGetUserHandler).getByName(this.name);

    }

    @Test
    void shouldReturnListEmptyWhenHandleIsCalledGetByNameWithParamNoExistisOrNull() {

        String nameNoExistis = "no existe";

        when(this.iGetUserHandler.getByName(nameNoExistis))
                .thenReturn(Collections.emptyList());

        List<ResponseUserDto> response = this.getByNameUserQueryHandler
                .handle(new GetByNameUserQuery(nameNoExistis));

        assertTrue(response.isEmpty());

        verify(this.iGetUserHandler).getByName(nameNoExistis);

    }

    @Test
    void shouldReturnCorrectRequestType() {
        Class<GetByNameUserQuery> result = this.getByNameUserQueryHandler.getRequestType();
        assertEquals(GetByNameUserQuery.class, result);
    }
}