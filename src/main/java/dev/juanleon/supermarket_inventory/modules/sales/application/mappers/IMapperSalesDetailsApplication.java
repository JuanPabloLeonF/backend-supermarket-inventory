package dev.juanleon.supermarket_inventory.modules.sales.application.mappers;

import dev.juanleon.supermarket_inventory.modules.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.RequestSalesDetailsDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDetailsDto;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesDetailsModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperProductsApplication.class}
)
public interface IMapperSalesDetailsApplication {
    @Mapping(target = "responseProductDto", source = "productModel")
    ResponseSalesDetailsDto toDto(SalesDetailsModel salesDetailsModel);

    @Mappings(value = {
            @Mapping(target = "salesModel", ignore = true),
            @Mapping(target = "productModel", ignore = true),
            @Mapping(target = "total", ignore = true),
            @Mapping(target = "priceUnit", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "productModel.id", source = "idProduct"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "discount", source = "discount"),
            @Mapping(target = "iva", source = "iva"),
    })
    SalesDetailsModel toModel(RequestSalesDetailsDto requestSalesDetailsDto);

    List<SalesDetailsModel> toModelList(List<RequestSalesDetailsDto> requestSalesDetailsDtoList);
}
