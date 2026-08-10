package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperUserInfrastructure.class}
)
public interface IMapperEmployeeInfrastructure {
    @Mapping(target = "userModel", source = "userEntity")
    EmployeeModel toModel(EmployeeEntity employeeEntity);
    @Mapping(target = "userEntity", source = "userModel")
    EmployeeEntity toEntity(EmployeeModel employeeModel);
}
