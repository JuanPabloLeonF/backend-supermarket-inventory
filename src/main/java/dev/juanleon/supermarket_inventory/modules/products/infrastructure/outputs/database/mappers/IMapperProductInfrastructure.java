package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.mappers.IMapperCategoriesInfrastructure;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperCategoriesInfrastructure.class}
)
public interface IMapperProductInfrastructure {

    @Mapping(target = "categoriesModel", source = "categoriesEntity")
    ProductModel toModel(ProductEntity productEntity);

    @Mapping(target = "categoriesEntity", source = "categoriesModel")
    ProductEntity toEntity(ProductModel productModel);
}
