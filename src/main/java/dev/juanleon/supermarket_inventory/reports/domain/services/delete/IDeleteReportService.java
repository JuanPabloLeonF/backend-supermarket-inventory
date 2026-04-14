package dev.juanleon.supermarket_inventory.reports.domain.services.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteReportService {
    ResponseModel deleteById(UUID id);
}
