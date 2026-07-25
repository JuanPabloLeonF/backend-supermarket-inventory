package dev.juanleon.supermarket_inventory.products.domain.useCases.post;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.post.IPostProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.services.post.IPostProductService;

import java.util.UUID;

public class PostProductUseCase implements IPostProductService {

    private final IPostProductPersistence iPostProductPersistence;
    private final IGetCategoriesServices iGetCategoriesServices;

    public PostProductUseCase(IPostProductPersistence iPostProductPersistence, IGetCategoriesServices iGetCategoriesServices) {
        this.iPostProductPersistence = iPostProductPersistence;
        this.iGetCategoriesServices = iGetCategoriesServices;
    }

    @Override
    public ResponseModel create(ProductModel productModel, UUID idCategories) {
        CategoriesModel categoriesModel = this.iGetCategoriesServices.getById(idCategories);
        productModel.setCategoriesModel(categoriesModel);
        String message = this.iPostProductPersistence.create(productModel);
        return new ResponseModel(message);
    }
}
