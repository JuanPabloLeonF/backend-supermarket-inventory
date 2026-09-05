package dev.juanleon.supermarket_inventory.share.mediator;

import dev.juanleon.supermarket_inventory.share.exception.NotFoundTypeRequestHandlerMediator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.NOT_FOUND_TYPE_REQUEST_HANDLER_MEDIATOR;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MediatorTest {

    private Mediator mediator;

    @BeforeEach
    void setUp() {
        this.mediator = new Mediator(List.of());
    }

    @Test
    void dispatchShouldThrowResponseWhenIsCalledMethodHandle() {

    }

    @Test
    void dispatchShouldThrowNotFoundTypeRequestHandlerMediatorWhenHandlerIsNull() {

        IRequest<String> request = new IRequest<String>() {};

        NotFoundTypeRequestHandlerMediator exception = assertThrows(
                NotFoundTypeRequestHandlerMediator.class,
                () -> this.mediator.dispatch(request)
        );

        assertTrue(exception.getMessage().startsWith(NOT_FOUND_TYPE_REQUEST_HANDLER_MEDIATOR.getMessage()));
    }
}