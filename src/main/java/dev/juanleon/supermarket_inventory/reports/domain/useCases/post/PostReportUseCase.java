package dev.juanleon.supermarket_inventory.reports.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.services.post.IPostReportService;

public class PostReportUseCase implements IPostReportService {

    private final IPostReportPersistence iPostReportPersistence;
    private final IFilesService iFilesService;

    public PostReportUseCase(IPostReportPersistence iPostReportPersistence, IFilesService iFilesService) {
        this.iPostReportPersistence = iPostReportPersistence;
        this.iFilesService = iFilesService;
    }

    @Override
    public ResponseModel create(ReportModel reportModel, InputFileDto inputFileDto) {
        this.iFilesService.createPdf(inputFileDto);
        this.iPostReportPersistence.create(reportModel);
        return null;
    }
}
