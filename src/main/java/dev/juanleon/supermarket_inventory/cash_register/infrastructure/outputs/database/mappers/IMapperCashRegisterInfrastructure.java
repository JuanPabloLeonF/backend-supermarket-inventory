package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.entities.CashRegisterEntity;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeInfrastructure.class}
)
public interface IMapperCashRegisterInfrastructure {
    CashRegisterModel toModel(CashRegisterEntity cashRegisterEntity);
    CashRegisterEntity toEntity(CashRegisterModel cashRegisterModel);
}
