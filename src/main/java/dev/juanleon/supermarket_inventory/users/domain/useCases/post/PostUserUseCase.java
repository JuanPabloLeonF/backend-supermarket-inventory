package dev.juanleon.supermarket_inventory.users.domain.useCases.post;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.services.post.IPostUserService;

public class PostUserUseCase implements IPostUserService {

    private final IPostUserPersistence iPostUserPersistence;

    public PostUserUseCase(IPostUserPersistence iPostUserPersistence) {
        this.iPostUserPersistence = iPostUserPersistence;
    }

    @Override
    public UserModel create(UserModel userModel) {
        return this.iPostUserPersistence.create(userModel);
    }
}
