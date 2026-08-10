package dev.juanleon.supermarket_inventory.modules.products.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.products.domain.persistence.delete.IDeleteProductPersistence;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.delete.IDeleteProductService;

import java.util.UUID;

public class DeleteProductUseCase implements IDeleteProductService {

    private final IDeleteProductPersistence iDeleteProductPersistence;

    public DeleteProductUseCase(IDeleteProductPersistence iDeleteProductPersistence) {
        this.iDeleteProductPersistence = iDeleteProductPersistence;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String response = this.iDeleteProductPersistence.deleteById(id);
        return new ResponseModel(response);
    }
}
