package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.update;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.update.IUpdateUserPersistence;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoUpdateUserByIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_UPDATE_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class UpdateUserAdapter implements IUpdateUserPersistence {

    private final IUserRepository iUserRepository;

    @Override
    public String updateById(UserModel userModel) {

        return this.iUserRepository.findById(userModel.id())
                .map((entity) -> {
                    entity.setName(userModel.name());
                    entity.setLastName(userModel.lastName());
                    entity.setIsActive(userModel.isActive());
                    entity.setUpdatedAt(LocalDateTime.now());
                    this.iUserRepository.save(entity);
                    return USER_UPDATE_SUCCESSFULLY_BY_ID.format(entity.getId());
                })
                .orElseThrow(() -> new NoUpdateUserByIdException(userModel.id()));
    }
}
