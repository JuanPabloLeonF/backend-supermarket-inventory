package dev.juanleon.supermarket_inventory.users.application.commands.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;
import dev.juanleon.supermarket_inventory.users.application.handler.update.IUpdateUserHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_UPDATE_SUCCESSFULLY_BY_ID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateByIdUserCommandHandlerTest {

    @Mock
    private IUpdateUserHandler iUpdateUserHandler;
    @InjectMocks
    private UpdateByIdUserCommandHandler updateByIdUserCommandHandler;

    protected UUID id = UUID.randomUUID();
    protected RequestUpdateUserDto requestUpdateUserDto;
    protected ResponseRequestDto responseRequestDto;
    protected UpdateByIdUserCommand updateByIdUserCommand;

    @BeforeEach
    void setUp() {
        this.requestUpdateUserDto = RequestUpdateUserDto
                .builder()
                .id(this.id)
                .name("juan")
                .lastName("león")
                .isActive(true)
                .build();

        this.responseRequestDto = ResponseRequestDto
                .builder()
                .message(USER_UPDATE_SUCCESSFULLY_BY_ID.format(this.id))
                .date(LocalDateTime.now())
                .build();

        this.updateByIdUserCommand = new UpdateByIdUserCommand(this.requestUpdateUserDto);
    }

    @Test
    void shouldReturnResponseRequestDto() {

        when(this.iUpdateUserHandler.updateById(this.updateByIdUserCommand.requestUpdateUserDto()))
                .thenReturn(this.responseRequestDto);

        ResponseRequestDto result = this.updateByIdUserCommandHandler.handle(this.updateByIdUserCommand);

        assertNotNull(result);
        assertNotNull(result.getDate());
        assertEquals(this.responseRequestDto.getMessage(), result.getMessage());

        verify(this.iUpdateUserHandler, times(1)).updateById(this.updateByIdUserCommand.requestUpdateUserDto());
    }

    @Test
    void shouldReturnRequestType() {
        Class<UpdateByIdUserCommand> result = this.updateByIdUserCommandHandler.getRequestType();
        assertNotNull(result);
        assertEquals(UpdateByIdUserCommand.class, result);
    }
}