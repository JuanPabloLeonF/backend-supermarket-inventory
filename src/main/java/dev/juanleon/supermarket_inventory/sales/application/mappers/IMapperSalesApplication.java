package dev.juanleon.supermarket_inventory.sales.application.mappers;

import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesRequestDTO;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeApplication.class}
)
public interface IMapperSalesApplication {

    @Mapping(target = "employeeModel", ignore = true)
    @Mapping(target = "id", ignore = true)
    SalesModel toModel(SalesRequestDTO salesRequestDTO);

    @Mapping(target = "employee", source = "employeeModel")
    SalesResponseDTO toResponse(SalesModel salesModel);
}
