package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.post.IPostProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.entities.ProviderEntity;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.mappers.IMapperProviderInfrastructure;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.repositories.IProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PROVIDER_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostProviderAdapter implements IPostProviderPersistence {

    private final IProviderRepository iProviderRepository;
    private final IMapperProviderInfrastructure iMapperProviderInfrastructure;

    @Override
    public String create(ProviderModel providerModel) {
        ProviderEntity entity = this.iMapperProviderInfrastructure.toEntity(providerModel);
        entity.setCreatedAt(LocalDate.now());
        UUID id = this.iProviderRepository.save(entity).getId();
        return PROVIDER_CREATED_SUCCESSFULLY.format(id);
    }
}
