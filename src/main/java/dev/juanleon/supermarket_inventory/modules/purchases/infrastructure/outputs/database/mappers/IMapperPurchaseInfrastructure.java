package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.entities.PurchaseEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeInfrastructure.class, IMapperPurchaseDetailsInfrastructure.class}
)
public interface IMapperPurchaseInfrastructure {

    @Mappings(value = {
            @Mapping(target = "employeeModel", source = "employeeEntity"),
            @Mapping(target = "providerModel", source = "providerEntity"),
            @Mapping(target = "purchaseDetailModelList", source = "purchaseDetailsEntityList")
    })
    PurchaseModel toModel(PurchaseEntity purchaseEntity);

    @Mappings(value = {
            @Mapping(target = "employeeEntity", source = "employeeModel"),
            @Mapping(target = "providerEntity", source = "providerModel"),
            @Mapping(target = "purchaseDetailsEntityList", source = "purchaseDetailModelList")
    })
    PurchaseEntity toEntity(PurchaseModel purchaseModel);

    @AfterMapping
    default void linkDetails(@MappingTarget PurchaseEntity purchaseEntity) {
        if (purchaseEntity.getPurchaseDetailsEntityList() != null) {
            purchaseEntity.getPurchaseDetailsEntityList().forEach(
                    detail -> detail.setPurchaseEntity(purchaseEntity)
            );
        }
    }
}
