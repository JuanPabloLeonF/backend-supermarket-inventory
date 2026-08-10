package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperUserInfrastructure {
    UserEntity toEntity(UserModel userModel);
    UserModel toModel(UserEntity userEntity);
    List<UserModel> toListModel(List<UserEntity> userEntities);
}
