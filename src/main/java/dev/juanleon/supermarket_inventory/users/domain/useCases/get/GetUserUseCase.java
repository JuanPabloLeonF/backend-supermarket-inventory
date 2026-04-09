package dev.juanleon.supermarket_inventory.users.domain.useCases.get;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.get.IGetUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.services.get.IGetUserService;

import java.util.List;
import java.util.UUID;

public class GetUserUseCase implements IGetUserService {

    private final IGetUserPersistence iGetUserPersistence;

    public GetUserUseCase(IGetUserPersistence iGetUserPersistence) {
        this.iGetUserPersistence = iGetUserPersistence;
    }

    @Override
    public List<UserModel> getAll() {
        return this.iGetUserPersistence.getAll();
    }

    @Override
    public UserModel getById(UUID id) {
        return this.iGetUserPersistence.getById(id);
    }

    @Override
    public List<UserModel> getByName(String name) {
        return this.iGetUserPersistence.getByName(name);
    }

    @Override
    public List<UserModel> getByLastName(String lastName) {
        return this.iGetUserPersistence.getByLastName(lastName);
    }

    @Override
    public void checkEmailIfExist(String email) {
        this.iGetUserPersistence.checkEmailIfExist(email);
    }
}
