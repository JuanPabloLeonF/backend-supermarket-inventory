package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.mappers.IMapperProductInfrastructure;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseDetailsModel;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.entities.PurchaseDetailsEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperProductInfrastructure.class}
)
public interface IMapperPurchaseDetailsInfrastructure {

    @Mappings(value = {
            @Mapping(target = "purchaseModel", ignore = true),
            @Mapping(target = "productModel", source = "productEntity")
    })
    PurchaseDetailsModel toModel(PurchaseDetailsEntity purchaseDetailsEntity);

    @Mappings(value = {
            @Mapping(target = "purchaseEntity", ignore = true),
            @Mapping(target = "productEntity", source = "productModel")
    })
    PurchaseDetailsEntity toEntity(PurchaseDetailsModel purchaseDetailsModel);
}
