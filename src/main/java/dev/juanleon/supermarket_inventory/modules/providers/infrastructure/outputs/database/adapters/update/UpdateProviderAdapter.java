package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.adapters.update;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.update.IUpdateProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.repositories.IProviderRepository;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.exceptions.NotFoundProviderException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PROVIDER_UPDATE_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class UpdateProviderAdapter implements IUpdateProviderPersistence {

    private final IProviderRepository iProviderRepository;

    @Override
    public String updateById(ProviderModel providerModel, UUID id) {
        return this.iProviderRepository.findById(id)
                .map(entity -> {
                    entity.setFullName(providerModel.getFullName());
                    entity.setCity(providerModel.getCity());
                    entity.setActivate(providerModel.getActivate());
                    entity.setDirection(providerModel.getDirection());
                    entity.setCellPhone(providerModel.getCellPhone());
                    entity.setEmail(providerModel.getEmail());
                    this.iProviderRepository.save(entity);
                    return PROVIDER_UPDATE_SUCCESSFULLY_BY_ID.format(entity.getId());
                })
                .orElseThrow(() -> new NotFoundProviderException(id));
    }
}
