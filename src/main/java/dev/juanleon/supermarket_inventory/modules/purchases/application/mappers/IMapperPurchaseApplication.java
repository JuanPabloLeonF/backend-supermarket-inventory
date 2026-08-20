package dev.juanleon.supermarket_inventory.modules.purchases.application.mappers;

import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.RequestPurchaseDto;
import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.ResponsePurchaseDto;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeApplication.class, IMapperPurchaseDetailsApplication.class}
)
public interface IMapperPurchaseApplication {

    @Mappings(value = {
            @Mapping(target = "employeeModel", ignore = true),
            @Mapping(target = "providerModel", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "total", ignore = true),
            @Mapping(target = "subTotal", ignore = true),
            @Mapping(target = "datePurchase", ignore = true),
            @Mapping(target = "discount", ignore = true),
            @Mapping(target = "numberPurchase", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "iva", ignore = true),
            @Mapping(target = "employeeModel.id", source = "employeeId"),
            @Mapping(target = "providerModel.id", source = "providerId"),
            @Mapping(target = "purchaseDetailModelList", source = "requestPurchaseDetailsDtoList"),
    })
    PurchaseModel toModel(RequestPurchaseDto requestPurchaseDto);

    ResponsePurchaseDto toResponse(PurchaseModel purchaseModel);
}
