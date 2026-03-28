package dev.juanleon.supermarket_inventory.users.application.commands.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.enums.Roles;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.post.IPostUserHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserCommandHandlerTest {

    @Mock
    private IPostUserHandler iPostUserHandler;

    @InjectMocks
    private CreateUserCommandHandler createUserCommandHandler;

    protected RequestUserDto requestUserDto;
    protected ResponseRequestDto responseRequestDto;

    @BeforeEach
    void setUp() {
        this.requestUserDto = RequestUserDto.builder()
                .name("juan")
                .lastName("leon")
                .email("juan123@gmail.com")
                .password("Abcd1234@")
                .rol(Roles.USER)
                .isActive(true)
                .build();

        this.responseRequestDto = ResponseRequestDto.builder()
                .message("User created successfully")
                .date(LocalDateTime.now().withNano(0))
                .build();
    }

    @Test
    void shouldReturnResponseRequestDtoWhenHandleIsCalledCreate() {

        CreateUserCommand command = new CreateUserCommand(this.requestUserDto);

        when(this.iPostUserHandler.create(this.requestUserDto))
                .thenReturn(this.responseRequestDto);

        ResponseRequestDto response = this.createUserCommandHandler.handle(command);

        assertNotNull(response);
        assertEquals(this.responseRequestDto, response);

        verify(this.iPostUserHandler).create(this.requestUserDto);
    }

    @Test
    void shouldReturnCorrectRequestType() {
        Class<CreateUserCommand> commandClass = this.createUserCommandHandler.getRequestType();
        assertEquals(CreateUserCommand.class, commandClass);
    }
}
