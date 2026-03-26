package dev.juanleon.supermarket_inventory.common.utils.mappers;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.models.ResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperResponseApp {
    public ResponseRequestDto toResponseRequestDto(ResponseModel responseModel);
}
