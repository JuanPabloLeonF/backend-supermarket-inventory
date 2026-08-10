package dev.juanleon.supermarket_inventory.modules.reports.domain.services.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteReportService {
    ResponseModel deleteById(UUID id);
}
