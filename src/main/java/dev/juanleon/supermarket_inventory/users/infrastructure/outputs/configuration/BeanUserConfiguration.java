package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.users.domain.persistence.delete.IDeleteUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.persistence.get.IGetUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.persistence.post.IPostUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.persistence.update.IUpdateUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.services.delete.IDeleteUserService;
import dev.juanleon.supermarket_inventory.users.domain.services.get.IGetUserService;
import dev.juanleon.supermarket_inventory.users.domain.services.post.IPostUserService;
import dev.juanleon.supermarket_inventory.users.domain.services.update.IUpdateUserService;
import dev.juanleon.supermarket_inventory.users.domain.useCases.delete.DeleteUserUseCase;
import dev.juanleon.supermarket_inventory.users.domain.useCases.get.GetUserUseCase;
import dev.juanleon.supermarket_inventory.users.domain.useCases.post.PostUserUseCase;
import dev.juanleon.supermarket_inventory.users.domain.useCases.update.UpdateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanUserConfiguration {

    @Bean
    public IGetUserService getUserService(IGetUserPersistence iGetUserPersistence) {
        return new GetUserUseCase(iGetUserPersistence);
    }

    @Bean
    public IPostUserService postUserService(IPostUserPersistence iPostUserPersistence) {
        return new PostUserUseCase(iPostUserPersistence);
    }

    @Bean
    public IUpdateUserService updateUserService(IUpdateUserPersistence iUpdateUserPersistence) {
        return new UpdateUserUseCase(iUpdateUserPersistence);
    }

    @Bean
    public IDeleteUserService deleteUserService(IDeleteUserPersistence iDeleteUserPersistence) {
        return new DeleteUserUseCase(iDeleteUserPersistence);
    }
}
