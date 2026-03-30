package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.users.domain.persistence.delete.IDeleteUserPersistence;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteUserAdapter implements IDeleteUserPersistence {
    private final IUserRepository iUserRepository;

    @Override
    public String deleteById(UUID id) {
        return this.iUserRepository.findById(id)
                .map(entity -> {
                    this.iUserRepository.deleteById(entity.getId());
                    return USER_DELETED_SUCCESSFULLY_BY_ID.format(id);
                })
                .orElseThrow(() -> new NotFoundUserException(id));
    }
}
