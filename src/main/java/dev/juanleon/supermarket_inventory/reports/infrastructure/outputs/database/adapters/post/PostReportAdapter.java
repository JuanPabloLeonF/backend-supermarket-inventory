package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.entities.ReportEntity;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.mappers.IMapperReportInfrastructure;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.repositories.IReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.REPORT_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostReportAdapter implements IPostReportPersistence {

    private final IReportRepository iReportRepository;
    private final IMapperReportInfrastructure iMapperReportInfrastructure;

    @Override
    public ResponseModel create(ReportModel reportModel) {
        ReportEntity entity = this.iMapperReportInfrastructure.toEntity(reportModel);
        UUID id = this.iReportRepository.save(entity).getId();
        return new ResponseModel(REPORT_CREATED_SUCCESSFULLY.format(id));
    }
}
