package dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.mappers.IMapperProductInfrastructure;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesDetailsModel;
import dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.database.entities.SalesDetailsEntity;
import org.mapstruct.*;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperProductInfrastructure.class}
)
public interface IMapperSalesDetailsInfrastructure {

    @Mappings(value = {
            @Mapping(target = "salesModel", ignore = true),
            @Mapping(target = "productModel", source = "productEntity")
    })
    SalesDetailsModel toModel(SalesDetailsEntity salesDetailsEntity);

    @Mappings(value = {
            @Mapping(target = "salesEntity", ignore = true),
            @Mapping(target = "productEntity", source = "productModel")
    })
    SalesDetailsEntity toEntity(SalesDetailsModel salesDetailsModel);
}
