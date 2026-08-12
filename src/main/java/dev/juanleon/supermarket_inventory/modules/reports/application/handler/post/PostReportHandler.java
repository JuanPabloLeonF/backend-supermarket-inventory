package dev.juanleon.supermarket_inventory.modules.reports.application.handler.post;

import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportSales;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.modules.reports.application.mappers.IMapperReportApplication;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.post.IPostReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostReportHandler implements IPostReportHandler {

    private final IPostReportService iPostReportService;
    private final IMapperReportApplication iMapperReportApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto createSale(RequestReportSales requestReportSales) {
        ReportModel reportModel = this.iMapperReportApplication.requestReportToModel(requestReportSales);
        SaleReportModel saleReportModel = this.iMapperReportApplication.salesReportToModel(requestReportSales);
        ResponseModel responseModel = this.iPostReportService.createSales(reportModel, saleReportModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
