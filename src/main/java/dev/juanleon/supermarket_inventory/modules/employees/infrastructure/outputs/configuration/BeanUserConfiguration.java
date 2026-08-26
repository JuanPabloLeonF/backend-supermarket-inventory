package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.ISecurityProviderUser;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetUserService;
import dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.get.GetUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanUserConfiguration {

    @Bean
    public IGetUserService iGetUserService(ISecurityProviderUser iSecurityProviderUser) {
        return new GetUserUseCase(iSecurityProviderUser);
    }
}
