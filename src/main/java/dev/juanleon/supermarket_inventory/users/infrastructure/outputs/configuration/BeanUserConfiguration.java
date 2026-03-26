package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.users.domain.persistence.get.IGetUserPersistence;
import dev.juanleon.supermarket_inventory.users.domain.services.get.IGetUserService;
import dev.juanleon.supermarket_inventory.users.domain.useCases.get.GetUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanUserConfiguration {

    @Bean
    public IGetUserService getUserService(IGetUserPersistence iGetUserPersistence) {
        return new GetUserUseCase(iGetUserPersistence);
    }
}
