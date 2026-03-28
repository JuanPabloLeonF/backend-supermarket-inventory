package dev.juanleon.supermarket_inventory.users.application.mappers;

import dev.juanleon.supermarket_inventory.common.utils.enums.Roles;
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

    public ResponseUserDto toDto(UserModel userModel);
    public List<ResponseUserDto> toDtoList(List<UserModel> userModelList);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "rol", source = "rol", qualifiedByName = "rolesToString")
    })
    public UserModel toModel(RequestUserDto requestUserDto);

    @Named("rolesToString")
    default String rolesToString(Roles roles) {
        return roles == null ? null : roles.name();
    }
}
