package dev.juanleon.supermarket_inventory.employees.application.commands.delete;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteByIdEmployeeAndUserCommand(
        UUID idEmployee,
        UUID idUser
) implements IRequest<ResponseRequestDto> { }
