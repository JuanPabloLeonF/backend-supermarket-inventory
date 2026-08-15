package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.delete.IDeleteProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.repositories.IProviderRepository;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.exceptions.NotFoundProviderException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PROVIDER_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteProviderAdapter implements IDeleteProviderPersistence {

    private final IProviderRepository iProviderRepository;

    @Override
    public String deleteById(UUID id) {
        return this.iProviderRepository.findById(id)
                .map(entity -> {;
                    this.iProviderRepository.deleteById(entity.getId());
                    return PROVIDER_DELETED_SUCCESSFULLY_BY_ID.format(entity.getId());
                })
                .orElseThrow(() -> new NotFoundProviderException(id));
    }
}
