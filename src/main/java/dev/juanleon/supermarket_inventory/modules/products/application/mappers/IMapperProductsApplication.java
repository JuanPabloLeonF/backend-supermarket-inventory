package dev.juanleon.supermarket_inventory.modules.products.application.mappers;

import dev.juanleon.supermarket_inventory.modules.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperInputFileDtoApp;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductDto;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductFileDto;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.RequestProductUpdateDto;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperCategoriesApplication.class, IMapperInputFileDtoApp.class}
)
public interface IMapperProductsApplication {

    @Mapping(target = "responseCategoriesDto", source = "categoriesModel")
    ResponseProductDto toDto(ProductModel productModel);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "categoriesModel", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "active", ignore = true),
            @Mapping(target = "urlImg", ignore = true)
    })
    ProductModel toModel(RequestProductDto requestProductDto);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "categoriesModel", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "active", ignore = true),
            @Mapping(target = "urlImg", ignore = true)
    })
    ProductModel toModel(RequestProductFileDto requestProductFileDto);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "categoriesModel", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "active", ignore = true),
            @Mapping(target = "urlImg", ignore = true)
    })
    ProductModel toModelUpdate(RequestProductUpdateDto requestProductUpdateDto);


    @Mapping(target = "inputFileDto", source = "imgFile")
    RequestProductFileDto toDto(RequestProductDto requestProductDto);
}
