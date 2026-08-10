package dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;

public interface IPostReportPersistence {
    ResponseModel create(ReportModel reportModel);
}
