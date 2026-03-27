package dev.juanleon.supermarket_inventory.users.application.queries.getAll;

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
class GetAllUserQueryHandlerTest {

    @Mock
    private IGetUserHandler iGetUserHandler;

    @InjectMocks
    private GetAllUserQueryHandler getAllUserQueryHandler;

    protected GetAllUserQuery getAllUserQuery = new GetAllUserQuery();
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
    void shouldReturnListResponseUserWhenHandleIsCalledGetAll() {

        when(this.iGetUserHandler.getAll())
                .thenReturn(this.responseUserDtoList);

        List<ResponseUserDto> response = this.getAllUserQueryHandler.handle(this.getAllUserQuery);

        assertNotNull(response);
        assertEquals(this.responseUserDtoList, response);

        verify(this.iGetUserHandler).getAll();

    }

    @Test
    void shouldReturnListEmptyWhenHandleIsCalledGetAll() {

        when(this.iGetUserHandler.getAll())
                .thenReturn(Collections.emptyList());

        List<ResponseUserDto> response = this.getAllUserQueryHandler.handle(this.getAllUserQuery);

        assertTrue(response.isEmpty());

        verify(this.iGetUserHandler).getAll();

    }

    @Test
    void shouldReturnCorrectRequestType() {
        Class<GetAllUserQuery> result = this.getAllUserQueryHandler.getRequestType();
        assertEquals(GetAllUserQuery.class, result);
    }
}