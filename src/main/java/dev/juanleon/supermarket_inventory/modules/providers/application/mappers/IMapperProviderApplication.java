package dev.juanleon.supermarket_inventory.modules.providers.application.mappers;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperProviderApplication {
    ResponseProviderDto toDto(ProviderModel providerModel);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    ProviderModel toModel(RequestProviderDto requestProviderDto);
}
