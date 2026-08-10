package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;

import java.util.UUID;

public record GetByIdEmployeeQuery(UUID id) implements IRequest<ResponseEmployeeDto> {
}
