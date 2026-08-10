package dev.juanleon.supermarket_inventory.modules.employees.application.commands.delete;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteByIdEmployeeAndUserCommand(UUID idEmployee) implements IRequest<ResponseRequestDto> { }
