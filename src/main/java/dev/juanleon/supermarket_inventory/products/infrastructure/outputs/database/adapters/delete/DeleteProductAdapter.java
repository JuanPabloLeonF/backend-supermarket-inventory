package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.products.domain.persistence.delete.IDeleteProductPersistence;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.repositories.IProductRepository;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions.NotFoundProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.PRODUCT_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteProductAdapter implements IDeleteProductPersistence {

    private final IProductRepository iProductRepository;

    @Override
    public String deleteById(UUID id) {
        return this.iProductRepository.findById(id)
                .map(product -> {
                    this.iProductRepository.deleteById(product.getId());
                    return PRODUCT_DELETED_SUCCESSFULLY_BY_ID.format(product.getId());
                })
                .orElseThrow(() -> new NotFoundProductException(id));
    }
}
