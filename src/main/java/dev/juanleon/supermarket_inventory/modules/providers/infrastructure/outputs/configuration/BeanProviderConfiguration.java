package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.get.IGetProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.get.IGetProviderService;
import dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.get.GetProviderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProviderConfiguration {

    @Bean
    public IGetProviderService iGetProviderService(IGetProviderPersistence iGetProviderPersistence) {
        return new GetProviderUseCase(iGetProviderPersistence);
    }
}
