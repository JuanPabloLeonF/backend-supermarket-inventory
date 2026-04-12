package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.mappers;

import dev.juanleon.supermarket_inventory.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.entities.ReportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {IMapperEmployeeApplication.class}
)
public interface IMapperReportInfrastructure {
    ReportModel toModel(ReportEntity reportEntity);
    ReportEntity toEntity(ReportModel reportModel);
}
