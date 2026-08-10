package dev.juanleon.supermarket_inventory.modules.categories.application.mappers;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperCategoriesApplication {
    @Mapping(target = "id", ignore = true)
    CategoriesModel toModel(RequestCategoriesDto requestCategoriesDto);

    CategoriesModel toModel(RequestUpdateCategoriesDto requestUpdateCategoriesDto);

    ResponseCategoriesDto toDto(CategoriesModel categoriesModel);
}
