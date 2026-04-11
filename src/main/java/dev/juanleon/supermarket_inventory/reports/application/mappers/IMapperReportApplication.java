package dev.juanleon.supermarket_inventory.reports.application.mappers;

import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportSalesData;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportSalesItemDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleItemDto;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperReportApplication {
    ResponseReport toResponse(ReportModel reportModel);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "filePath", ignore = true),
            @Mapping(target = "generatedAt", ignore = true),
            @Mapping(target = "employee", ignore = true)
    })
    ReportModel toModel(RequestReportDto requestReportDto);

    SaleItemDto toModel(RequestReportSalesItemDto requestReportSalesItemDto);

    List<SaleItemDto> toModelList(List<RequestReportSalesItemDto> list);

    @Mapping(target = "createdAt", ignore = true)
    SaleReportModel toModel(RequestReportSalesData requestReportSalesData);
}
