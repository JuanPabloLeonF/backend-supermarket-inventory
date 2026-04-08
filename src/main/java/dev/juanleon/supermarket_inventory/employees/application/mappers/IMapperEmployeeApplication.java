package dev.juanleon.supermarket_inventory.employees.application.mappers;

import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestUpdateEmployeeAndUser;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import org.mapstruct.*;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperUserApplication.class}
)
public interface IMapperEmployeeApplication {

    @Mapping(target = "urlImg", ignore = true)
    @Mapping(target = "userModel", source = "requestUserUpdateDto")
    EmployeeModel toModel(RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "userModel", source = "requestUserDto"),
            @Mapping(target = "urlImg", ignore = true)
    })
    EmployeeModel toModel(RequestEmployeeDto requestEmployeeDto);

    @Mapping(target = "responseUserDto", source = "userModel")
    ResponseEmployeeDto toDto(EmployeeModel employeeModel);
}
