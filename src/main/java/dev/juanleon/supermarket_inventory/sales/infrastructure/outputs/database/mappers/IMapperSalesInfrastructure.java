package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.entities.SalesEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeInfrastructure.class}
)
public interface IMapperSalesInfrastructure {
    @Mapping(target = "employee", source = "employeeModel")
    SalesEntity toEntity(SalesModel salesModel);
    @Mapping(target = "employeeModel", source = "employee")
    SalesModel toModel(SalesEntity salesEntity);
}
