package dev.juanleon.supermarket_inventory.users.application.queries.getBy;

import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.get.IGetUserHandler;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetByIdUserQueryHandlerTest {

    @Mock
    private IGetUserHandler iGetUserHandler;

    @InjectMocks
    private GetByIdUserQueryHandler getByIdUserQueryHandler;

    protected UUID id1 = UUID.randomUUID();
    protected ResponseUserDto responseUserDto;

    protected GetByIdUserQuery getByIdUserQuery = new GetByIdUserQuery(this.id1);

    @BeforeEach
    void setUp() {
        this.responseUserDto = ResponseUserDto.builder()
                .id(this.id1)
                .name("juan")
                .lastName("leon")
                .email("juan123@gmail.com")
                .rol("ADMIN")
                .isActive(true)
                .password("123456789")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    void shouldReturnResponseUserDtoWhenIsCalledMethodGetByIdWithParam() {

        when(this.iGetUserHandler.getById(this.id1))
                .thenReturn(this.responseUserDto);

        ResponseUserDto response = this.getByIdUserQueryHandler.handle(this.getByIdUserQuery);

        assertNotNull(response);
        assertEquals(this.responseUserDto, response);

        verify(this.iGetUserHandler).getById(this.id1);

    }

    @Test
    void shouldPropagateNotFoundUserExceptionWhenIsCalledMethodGetByIdWithParamNotExistOrNull() {

        UUID idNoExistis = UUID.randomUUID();
        String message = "User not found with id: " + idNoExistis;

        when(this.iGetUserHandler.getById(idNoExistis))
                .thenThrow(new NotFoundUserException(message));

        NotFoundUserException exception = assertThrows(NotFoundUserException.class, () -> {
            this.getByIdUserQueryHandler.handle(new GetByIdUserQuery(idNoExistis));
        });

        assertEquals(message, exception.getMessage());
        assertEquals(NotFoundUserException.class, exception.getClass());

        verify(this.iGetUserHandler).getById(idNoExistis);

    }

    @Test
    void shouldReturnCorrectRequestType() {
        Class<GetByIdUserQuery> queryClass = this.getByIdUserQueryHandler.getRequestType();
        assertEquals(GetByIdUserQuery.class, queryClass);
    }
}