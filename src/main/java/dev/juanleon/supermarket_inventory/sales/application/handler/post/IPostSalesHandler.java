package dev.juanleon.supermarket_inventory.sales.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesRequestDTO;

import java.util.UUID;

public interface IPostSalesHandler {
    ResponseRequestDto create(SalesRequestDTO salesRequestDTO, UUID employeeId);
}
