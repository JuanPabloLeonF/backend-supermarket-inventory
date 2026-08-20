package dev.juanleon.supermarket_inventory.modules.purchases.application.mappers;

import dev.juanleon.supermarket_inventory.modules.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.RequestPurchaseDetailsDto;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseDetailsModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperProductsApplication.class}
)
public interface IMapperPurchaseDetailsApplication {

//    @Mapping(target = "responseProductDto", source = "productModel")
//    ResponseSalesDetailsDto toDto(SalesDetailsModel salesDetailsModel);

    @Mappings(value = {
            @Mapping(target = "purchaseModel", ignore = true),
            @Mapping(target = "productModel", ignore = true),
            @Mapping(target = "total", ignore = true),
            @Mapping(target = "priceUnit", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "subTotal", ignore = true),
            @Mapping(target = "productModel.id", source = "idProduct"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "discount", source = "discount"),
            @Mapping(target = "iva", source = "iva")
    })
    PurchaseDetailsModel toModel(RequestPurchaseDetailsDto requestPurchaseDetailsDto);

    List<PurchaseDetailsModel> toModelList(List<RequestPurchaseDetailsDto> requestPurchaseDetailsDtoList);
}
