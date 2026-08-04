package dev.juanleon.supermarket_inventory.sales.application.mappers;

import dev.juanleon.supermarket_inventory.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.sales.application.dto.ResponseSalesDetailsDto;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesDetailsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperProductsApplication.class}
)
public interface IMapperSalesDetailsApplication {
    @Mapping(target = "responseProductDto", source = "productModel")
    ResponseSalesDetailsDto toDto(SalesDetailsModel salesDetailsModel);
}
