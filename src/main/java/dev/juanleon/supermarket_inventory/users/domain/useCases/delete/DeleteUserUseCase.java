package dev.juanleon.supermarket_inventory.users.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.users.domain.models.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.delete.IDeleteUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.services.delete.IDeleteUserService;

import java.util.UUID;

public class DeleteUserUseCase implements IDeleteUserService {

    private final IDeleteUserPersistence iDeleteUserPersistence;

    public DeleteUserUseCase(IDeleteUserPersistence iDeleteUserPersistence) {
        this.iDeleteUserPersistence = iDeleteUserPersistence;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String response = this.iDeleteUserPersistence.deleteById(id);
        return new ResponseModel(response);
    }
}
