package dev.juanleon.supermarket_inventory.reports.domain.persistence.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;

public interface IPostReportPersistence {
    ResponseModel create(ReportModel reportModel);
}
