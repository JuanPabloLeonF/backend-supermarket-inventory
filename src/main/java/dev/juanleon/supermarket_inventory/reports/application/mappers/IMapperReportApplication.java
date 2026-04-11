package dev.juanleon.supermarket_inventory.reports.application.mappers;

import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

import java.util.function.Function;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperReportApplication {
    ResponseReport toResponse(ReportModel reportModel);
    ReportModel toModel(RequestReportDto requestReportDto);
}
