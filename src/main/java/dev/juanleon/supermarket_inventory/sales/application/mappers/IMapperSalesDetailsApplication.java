package dev.juanleon.supermarket_inventory.sales.application.mappers;

import dev.juanleon.supermarket_inventory.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.sales.application.dto.RequestSalesDetailsDto;
import dev.juanleon.supermarket_inventory.sales.application.dto.ResponseSalesDetailsDto;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesDetailsModel;
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
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "total", ignore = true)
    })
    SalesDetailsModel toModel(RequestSalesDetailsDto requestSalesDetailsDto);

    List<SalesDetailsModel> toModelList(List<RequestSalesDetailsDto> requestSalesDetailsDtoList);
}
