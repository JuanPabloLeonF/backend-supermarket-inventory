package dev.juanleon.supermarket_inventory.reports.domain.services.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;

public interface IPostReportService {
    ResponseModel create(ReportModel reportModel, InputFileDto inputFileDto);
}
