package dev.juanleon.supermarket_inventory.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.employees.application.dto.ResponseEmployeeDto;

import java.util.UUID;

public record GetByIdEmployeeQuery(UUID id) implements IRequest<ResponseEmployeeDto> {
}
