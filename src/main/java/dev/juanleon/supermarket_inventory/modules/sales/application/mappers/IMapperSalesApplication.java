package dev.juanleon.supermarket_inventory.modules.sales.application.mappers;

import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.RequestSalesDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
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
            @Mapping(target = "total", ignore = true),
            @Mapping(target = "subTotal", ignore = true),
            @Mapping(target = "dateSale", ignore = true),
            @Mapping(target = "discount", ignore = true),
            @Mapping(target = "numberSale", ignore = true),
            @Mapping(target = "employeeModel.id", source = "employeeId"),
            @Mapping(target = "salesDetailsModelList", source = "requestSalesDetailsDtoList"),
    })
    SalesModel toModel(RequestSalesDto requestSalesDto);

    @Mappings(value = {
            @Mapping(target = "employee", source = "employeeModel"),
            @Mapping(target = "responseSalesDetailsDtoList", source = "salesDetailsModelList")
    })
    ResponseSalesDto toResponse(SalesModel salesModel);
}
