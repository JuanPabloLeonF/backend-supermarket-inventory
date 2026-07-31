package dev.juanleon.supermarket_inventory.products.domain.useCases.update;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.update.IUpdateProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.ports.IPortFilesProducts;
import dev.juanleon.supermarket_inventory.products.domain.services.update.IUpdateProductService;

import java.util.UUID;

public class UpdateProductUseCase implements IUpdateProductService {

    private final IUpdateProductPersistence iUpdateProductPersistence;
    private final IGetCategoriesServices iGetCategoriesServices;
    private final IPortFilesProducts iPortFilesProducts;
    private final AppConfigurationProperties appConfigurationProperties;

    public UpdateProductUseCase(IUpdateProductPersistence iUpdateProductPersistence, IGetCategoriesServices iGetCategoriesServices, IPortFilesProducts iPortFilesProducts, AppConfigurationProperties appConfigurationProperties) {
        this.iUpdateProductPersistence = iUpdateProductPersistence;
        this.iGetCategoriesServices = iGetCategoriesServices;
        this.iPortFilesProducts = iPortFilesProducts;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel update(UUID productId, ProductModel productModel, UUID categoryId) {
        CategoriesModel categoriesModel = this.iGetCategoriesServices.getById(categoryId);
        productModel.setCategoriesModel(categoriesModel);
        String response = this.iUpdateProductPersistence.update(productId, productModel);
        return new ResponseModel(response);
    }

    @Override
    public ResponseModel updateActive(UUID productId, Boolean active) {
        String response = this.iUpdateProductPersistence.updateActive(productId, active);
        return new ResponseModel(response);
    }

    @Override
    public ResponseModel updateUrlImg(UUID productId, InputFileDto inputFileDto) {
        String urlImgUpdate = this.iPortFilesProducts.createImage(
                inputFileDto,
                this.appConfigurationProperties.getPathUploadImagesProducts()
        );
        String response = this.iUpdateProductPersistence.updateUrlImg(
                productId,
                urlImgUpdate,
                this.appConfigurationProperties.getPathUploadImagesProducts()
        );
        return new ResponseModel(response);
    }
}
