package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.mappers.IMapperProviderInfrastructure;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.repositories.IProviderRepository;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.exceptions.NotFoundProviderException;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IProviderProviderPurchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PurchaseProviderProviderAdapter implements IProviderProviderPurchase {

    private final IProviderRepository iProviderRepository;
    private final IMapperProviderInfrastructure iMapperProviderInfrastructure;

    @Override
    public ProviderModel getProviderById(UUID id) {
        return this.iProviderRepository.findById(id)
                .map(this.iMapperProviderInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundProviderException(id));
    }
}
