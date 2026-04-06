package dev.juanleon.supermarket_inventory.users.domain.useCases.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.update.IUpdateUserPersistence;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseTest {

    @Mock
    private IUpdateUserPersistence iUpdateUserPersistence;

    @InjectMocks
    private UpdateUserUseCase updateUserUseCase;

    protected UserModel userModel;
    protected UUID id1 = UUID.randomUUID();
    protected ResponseModel responseModel;

    @BeforeEach
    void setUp() {
        this.userModel = new UserModel(
                this.id1,
                "fabian",
                "contreras",
                "fabian@gmail.com",
                "12345678",
                "USER",
                false,
                LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0)
        );

        this.responseModel = new ResponseModel(USER_UPDATE_SUCCESSFULLY_BY_ID.format(this.userModel.id()));

    }

    @Test
    void shouldReturnUserModelWhenUpdateByIdIsCalled() {

        String message = USER_UPDATE_SUCCESSFULLY_BY_ID.format(this.userModel.id());

        when(this.iUpdateUserPersistence.updateById(this.userModel))
                .thenReturn(message);

        ResponseModel response = this.updateUserUseCase.updateById(this.userModel);

        assertNotNull(response);
        assertEquals(this.responseModel.message(), response.message());
        assertNotNull(response.dateTime());

        verify(this.iUpdateUserPersistence).updateById(this.userModel);
    }
}