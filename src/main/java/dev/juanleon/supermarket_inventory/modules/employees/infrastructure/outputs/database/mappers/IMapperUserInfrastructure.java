package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.security.authentication.SecurityUserModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperUserInfrastructure {
    UserEntity toEntity(UserModel userModel);
    UserModel toModel(UserEntity userEntity);
    List<UserModel> toListModel(List<UserEntity> userEntities);

    @Mappings(value = {
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "role", source = "rol"),
    })
    SecurityUserModel toSecurityModel(UserEntity userEntity);
}
