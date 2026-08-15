package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.get.IGetProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.post.IPostProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.update.IUpdateProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.get.IGetProviderService;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.post.IPostProviderService;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.update.IUpdateProviderService;
import dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.delete.DeleteProviderUseCases;
import dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.get.GetProviderUseCase;
import dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.post.PostProviderUseCase;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.delete.IDeleteProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.domain.services.delete.IDeleteProviderService;
import dev.juanleon.supermarket_inventory.modules.providers.domain.useCases.update.UpdateProviderUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProviderConfiguration {

    @Bean
    public IGetProviderService iGetProviderService(IGetProviderPersistence iGetProviderPersistence) {
        return new GetProviderUseCase(iGetProviderPersistence);
    }

    @Bean
    public IPostProviderService iPostProviderService(IPostProviderPersistence iPostProviderPersistence) {
        return new PostProviderUseCase(iPostProviderPersistence);
    }

    @Bean
    public IUpdateProviderService iUpdateProviderService(IUpdateProviderPersistence iUpdateProviderPersistence) {
        return new UpdateProviderUseCases(iUpdateProviderPersistence);
    }

    @Bean
    public IDeleteProviderService iDeleteProviderService(IDeleteProviderPersistence iDeleteProviderPersistence) {
        return new DeleteProviderUseCases(iDeleteProviderPersistence);
    }
}
