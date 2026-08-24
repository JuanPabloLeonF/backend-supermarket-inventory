package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.share.files.events.FileDeletedEvent;
import dev.juanleon.supermarket_inventory.modules.products.domain.persistence.delete.IDeleteProductPersistence;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.repositories.IProductRepository;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.NotFoundProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp.PATH_UPLOAD_IMAGES_PRODUCTS;
import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PRODUCT_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteProductAdapter implements IDeleteProductPersistence {

    private final IProductRepository iProductRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String deleteById(UUID id) {
        return this.iProductRepository.findById(id)
                .map(product -> {
                    this.applicationEventPublisher.publishEvent(new FileDeletedEvent(
                            product.getUrlImg(),
                            PATH_UPLOAD_IMAGES_PRODUCTS
                    ));
                    this.iProductRepository.deleteById(product.getId());
                    return PRODUCT_DELETED_SUCCESSFULLY_BY_ID.format(product.getId());
                })
                .orElseThrow(() -> new NotFoundProductException(id));
    }
}
