package dev.juanleon.supermarket_inventory.products.domain.useCases.update;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.update.IUpdateProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.services.update.IUpdateProductService;

import java.time.LocalDate;
import java.util.UUID;

public class UpdateProductUseCase implements IUpdateProductService {

    private final IUpdateProductPersistence iUpdateProductPersistence;
    private final IGetCategoriesServices iGetCategoriesServices;

    public UpdateProductUseCase(IUpdateProductPersistence iUpdateProductPersistence, IGetCategoriesServices iGetCategoriesServices) {
        this.iUpdateProductPersistence = iUpdateProductPersistence;
        this.iGetCategoriesServices = iGetCategoriesServices;
    }

    @Override
    public ResponseModel update(UUID productId, ProductModel productModel, UUID categoryId) {
        CategoriesModel categoriesModel = this.iGetCategoriesServices.getById(productModel.getCategoriesModel().getId());
        productModel.setCategoriesModel(categoriesModel);
        productModel.setUpdatedAt(LocalDate.now());
        String response = this.iUpdateProductPersistence.update(productId, productModel);
        return new ResponseModel(response);
    }

    @Override
    public ResponseModel updateActive(UUID productId, Boolean active) {
        String response = this.iUpdateProductPersistence.updateActive(productId, active, LocalDate.now());
        return new ResponseModel(response);
    }
}
