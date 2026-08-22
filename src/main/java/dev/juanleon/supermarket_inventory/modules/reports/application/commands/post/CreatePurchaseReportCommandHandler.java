package dev.juanleon.supermarket_inventory.modules.reports.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.reports.application.mappers.IMapperReportApplication;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.DataReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.post.IPostReportService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreatePurchaseReportCommandHandler implements IRequestHandler<CreatePurchaseReportCommand, ResponseRequestDto> {

    private final IPostReportService iPostReportService;
    private final IMapperReportApplication iMapperReportApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(CreatePurchaseReportCommand request) {
        ReportModel reportModel = this.iMapperReportApplication.requestReportPurchaseToModel(request.requestReportDataPurchases());
        DataReportModel<PurchaseModel> dataReportModel = this.iMapperReportApplication.purchaseReportToModel(request.requestReportDataPurchases());
        ResponseModel responseModel = this.iPostReportService.createPurchase(reportModel, dataReportModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<CreatePurchaseReportCommand> getRequestType() {
        return CreatePurchaseReportCommand.class;
    }
}
