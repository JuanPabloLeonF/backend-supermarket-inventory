package dev.juanleon.supermarket_inventory.modules.reports.application.commands.delete;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteByIdReportCommand(UUID id) implements IRequest<ResponseRequestDto> {
}
