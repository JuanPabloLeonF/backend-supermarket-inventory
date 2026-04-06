package dev.juanleon.supermarket_inventory.users.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;
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
class PostUserUseCaseTest {

    @Mock
    private IPostUserPersistence iPostUserPersistence;

    @InjectMocks
    private PostUserUseCase postUserUseCase;

    protected UserModel userModel;

    protected UUID id1 = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        this.userModel = new UserModel(
                this.id1,
                "juan",
                "leon",
                "juan123@gmail.com",
                "1234567",
                "ADMIN",
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Test
    void shouldReturnResponseModelWhenIsCalledMethodCreate() {
        String messagePersistence = "User created successfully with id: " + this.userModel.id();

        when(this.iPostUserPersistence.create(this.userModel)).thenReturn(messagePersistence);

        ResponseModel response = this.postUserUseCase.create(this.userModel);

        assertNotNull(response);
        assertEquals(messagePersistence, response.message());
        assertNotNull(response.dateTime());

        verify(this.iPostUserPersistence).create(this.userModel);
    }
}
