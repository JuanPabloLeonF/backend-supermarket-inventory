package dev.juanleon.supermarket_inventory.modules.employees.application.mappers;

import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestUserDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestUserUpdateDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseUserDto;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.UserModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface IMapperUserApplication {

    ResponseUserDto toDto(UserModel userModel);
    List<ResponseUserDto> toDtoList(List<UserModel> userModelList);

    @Mappings(value = {
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    UserModel toModel(RequestUserUpdateDto requestUserUpdateDto);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    UserModel toModel(RequestUserDto requestUserDto);
}
