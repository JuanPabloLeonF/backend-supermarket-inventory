package dev.juanleon.supermarket_inventory.cash_register.application.mappers;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeApplication.class}
)
public interface IMapperCashRegisterApplication {
    CashRegisterResponse toResponse(CashRegisterModel cashRegisterModel);
}
