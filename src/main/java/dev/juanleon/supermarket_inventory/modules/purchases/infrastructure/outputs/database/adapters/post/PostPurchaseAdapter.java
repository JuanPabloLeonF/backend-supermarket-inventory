package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.persistence.post.IPostPurchasePersistence;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.entities.PurchaseEntity;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.mappers.IMapperPurchaseInfrastructure;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.repositories.IPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PURCHASE_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostPurchaseAdapter implements IPostPurchasePersistence {

    private final IPurchaseRepository iPurchaseRepository;
    private final IMapperPurchaseInfrastructure iMapperPurchaseInfrastructure;

    @Override
    public String create(PurchaseModel purchaseModel) {
        PurchaseEntity entity = this.iMapperPurchaseInfrastructure.toEntity(purchaseModel);
        UUID id = this.iPurchaseRepository.save(entity).getId();
        return PURCHASE_CREATED_SUCCESSFULLY.format(id);
    }
}
