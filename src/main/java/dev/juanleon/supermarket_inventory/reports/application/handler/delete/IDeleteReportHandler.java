package dev.juanleon.supermarket_inventory.reports.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteReportHandler {
    ResponseRequestDto deleteById(UUID id);
}
