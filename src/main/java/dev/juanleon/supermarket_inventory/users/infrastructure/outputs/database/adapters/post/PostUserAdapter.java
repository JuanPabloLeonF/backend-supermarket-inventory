package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.mappers.IMapperUserInfrastructure;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoCreateUserOnDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
@RequiredArgsConstructor
public class PostUserAdapter implements IPostUserPersistence {

    private final IUserRepository iUserRepository;
    private final IMapperUserInfrastructure iMapperUserInfrastructure;

    @Override
    public UserModel create(UserModel userModel) {
        
        UserEntity entity = this.iMapperUserInfrastructure.toEntity(userModel);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        UserEntity userCreated = this.iUserRepository.save(entity);

        if (userCreated.getId() == null) {
            throw new NoCreateUserOnDatabaseException(userModel.getEmail(), userModel.getName());
        }

        return this.iMapperUserInfrastructure.toModel(userCreated);
    }
}
