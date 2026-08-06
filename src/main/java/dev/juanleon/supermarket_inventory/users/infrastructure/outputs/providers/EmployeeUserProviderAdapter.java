package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.employees.domain.ports.IUserProviderEmployee;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.mappers.IMapperUserInfrastructure;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.EmailAlreadyExistsException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoCreateUserOnDatabaseException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoUpdateUserByIdException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_DELETED_SUCCESSFULLY_BY_ID;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_UPDATE_SUCCESSFULLY_BY_ID;

@Component
@RequiredArgsConstructor
public class EmployeeUserProviderAdapter implements IUserProviderEmployee {

    private final IUserRepository iUserRepository;
    private final IMapperUserInfrastructure iMapperUserInfrastructure;

    @Override
    public void checkEmailOfUserIfExist(String email) {
        this.iUserRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new EmailAlreadyExistsException(user.getEmail());
                });
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        UserEntity entity = this.iMapperUserInfrastructure.toEntity(userModel);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        UserEntity userCreated = this.iUserRepository.save(entity);

        if (userCreated.getId() == null) {
            throw new NoCreateUserOnDatabaseException(userModel.getEmail(), userModel.getName());
        }

        return this.iMapperUserInfrastructure.toModel(userCreated);
    }

    @Override
    public String updateUserById(UserModel userModel) {
        return this.iUserRepository.findById(userModel.getId())
                .map((entity) -> {
                    entity.setName(userModel.getName());
                    entity.setLastName(userModel.getLastName());
                    entity.setIsActive(userModel.getIsActive());
                    entity.setUpdatedAt(LocalDateTime.now());
                    this.iUserRepository.save(entity);
                    return USER_UPDATE_SUCCESSFULLY_BY_ID.format(entity.getId());
                }).orElseThrow(() -> new NoUpdateUserByIdException(userModel.getId()));
    }

    @Override
    public String deleteUserById(UUID id) {
        return this.iUserRepository.findById(id)
                .map(entity -> {
                    this.iUserRepository.deleteById(entity.getId());
                    return USER_DELETED_SUCCESSFULLY_BY_ID.format(id);
                }).orElseThrow(() -> new NotFoundUserException(id));
    }
}
