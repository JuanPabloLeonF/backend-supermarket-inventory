package dev.juanleon.supermarket_inventory.employees.application.mappers;

import dev.juanleon.supermarket_inventory.employees.application.dto.RequestEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.dto.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import org.mapstruct.*;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperUserApplication.class}
)
public interface IMapperEmployeeApplication {

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "userModel", source = "requestUserDto"),
            @Mapping(target = "urlImg", ignore = true)
    })
    EmployeeModel toModel(RequestEmployeeDto requestEmployeeDto);

    @Mapping(target = "responseUserDto", source = "userModel")
    ResponseEmployeeDto toDto(EmployeeModel employeeModel);
}
