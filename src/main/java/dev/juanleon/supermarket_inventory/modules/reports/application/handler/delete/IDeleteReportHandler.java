package dev.juanleon.supermarket_inventory.modules.reports.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteReportHandler {
    ResponseRequestDto deleteById(UUID id);
}
