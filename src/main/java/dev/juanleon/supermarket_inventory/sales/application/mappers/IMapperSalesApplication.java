package dev.juanleon.supermarket_inventory.sales.application.mappers;

import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.sales.application.dto.RequestSalesDto;
import dev.juanleon.supermarket_inventory.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeApplication.class, IMapperSalesDetailsApplication.class}
)
public interface IMapperSalesApplication {

    @Mappings(value = {
            @Mapping(target = "employeeModel", ignore = true),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "salesDetailsModelList", source = "requestSalesDetailsDtoList"),
            @Mapping(target = "salesDetailsModelList", source = "requestSalesDetailsDtoList"),
    })
    SalesModel toModel(RequestSalesDto requestSalesDto);

    @Mappings(value = {
            @Mapping(target = "employee", source = "employeeModel"),
            @Mapping(target = "responseSalesDetailsDtoList", source = "salesDetailsModelList")
    })
    ResponseSalesDto toResponse(SalesModel salesModel);
}
