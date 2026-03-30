package dev.juanleon.supermarket_inventory.users.application.mappers;

import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperUserApplication {

    ResponseUserDto toDto(UserModel userModel);
    List<ResponseUserDto> toDtoList(List<UserModel> userModelList);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
    })
    UserModel toModel(RequestUserDto requestUserDto);

    @Mappings(value = {
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "email", ignore = true),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "rol", ignore = true),
    })
    UserModel toModel(RequestUpdateUserDto requestUpdateUserDto);
}
