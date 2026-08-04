package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.entities.SalesEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeInfrastructure.class, IMapperSalesDetailsInfrastructure.class}
)
public interface IMapperSalesInfrastructure {

    @Mappings(value = {
            @Mapping(target = "employee", source = "employeeModel"),
            @Mapping(target = "salesDetailsEntityList", source = "salesDetailsModelList")
    })
    SalesEntity toEntity(SalesModel salesModel);

    @Mappings(value = {
            @Mapping(target = "employeeModel", source = "employee"),
            @Mapping(target = "salesDetailsModelList", source = "salesDetailsEntityList")
    })
    SalesModel toModel(SalesEntity salesEntity);
}
