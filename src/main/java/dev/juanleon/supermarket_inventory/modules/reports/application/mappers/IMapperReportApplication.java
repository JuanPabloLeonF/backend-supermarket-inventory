package dev.juanleon.supermarket_inventory.modules.reports.application.mappers;

import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportSales;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = { IMapperEmployeeApplication.class }
)
public interface IMapperReportApplication {

    ResponseReport toResponse(ReportModel reportModel);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "filePath", ignore = true),
            @Mapping(target = "generatedAt", ignore = true),
            @Mapping(target = "employee", ignore = true),
            @Mapping(target = "reportType", source = "reportType"),
            @Mapping(target = "period", source = "period"),
    })
    ReportModel requestReportToModel(RequestReportSales requestReportSales);

    @Mappings(value = {
            @Mapping(target = "salesModel.id", source = "salesId")
    })
    SaleReportModel salesReportToModel(RequestReportSales requestReportSales);
}
