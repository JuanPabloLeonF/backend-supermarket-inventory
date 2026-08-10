package dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.entities.CategoriesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperCategoriesInfrastructure {
    CategoriesEntity toEntity(CategoriesModel categoriesModel);
    CategoriesModel toModel(CategoriesEntity categoriesEntity);
}
