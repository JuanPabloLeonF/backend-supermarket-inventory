package dev.juanleon.supermarket_inventory.products.domain.useCases.post;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.post.IPostProductPersistence;
import dev.juanleon.supermarket_inventory.products.domain.ports.ICategoriesProviderProduct;
import dev.juanleon.supermarket_inventory.products.domain.ports.IFilesProviderProduct;
import dev.juanleon.supermarket_inventory.products.domain.services.post.IPostProductService;

import java.time.LocalDate;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties.PATH_UPLOAD_IMAGES_PRODUCTS;

public class PostProductUseCase implements IPostProductService {

    private final IPostProductPersistence iPostProductPersistence;
    private final ICategoriesProviderProduct iCategoriesProviderProduct;
    private final IFilesProviderProduct iFilesProviderProduct;

    public PostProductUseCase(IPostProductPersistence iPostProductPersistence, ICategoriesProviderProduct iCategoriesProviderProduct, IFilesProviderProduct iFilesProviderProduct) {
        this.iPostProductPersistence = iPostProductPersistence;
        this.iCategoriesProviderProduct = iCategoriesProviderProduct;
        this.iFilesProviderProduct = iFilesProviderProduct;
    }

    @Override
    public ResponseModel create(ProductModel productModel, UUID idCategories, InputFileDto inputFileDto) {

        CategoriesModel categoriesModel = this.iCategoriesProviderProduct.getCategoryById(idCategories);
        productModel.setCategoriesModel(categoriesModel);

        String urlImg = this.iFilesProviderProduct.createImage(inputFileDto, PATH_UPLOAD_IMAGES_PRODUCTS);

        productModel.setUrlImg(urlImg);
        productModel.setActive(true);
        LocalDate localDate = LocalDate.now();
        productModel.setCreatedAt(localDate);
        productModel.setUpdatedAt(localDate);
        String message = this.iPostProductPersistence.create(productModel);
        return new ResponseModel(message);
    }
}
