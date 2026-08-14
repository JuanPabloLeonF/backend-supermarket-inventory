package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.entities.ProviderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperProviderInfrastructure {

    ProviderModel toModel(ProviderEntity providerEntity);

    ProviderEntity toEntity(ProviderModel providerModel);
}
