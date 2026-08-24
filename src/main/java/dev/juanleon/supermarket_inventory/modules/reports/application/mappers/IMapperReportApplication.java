package dev.juanleon.supermarket_inventory.modules.reports.application.mappers;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportDataPurchases;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportDataSales;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.DataReportModel;
import dev.juanleon.supermarket_inventory.modules.employees.application.mappers.IMapperEmployeeApplication;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
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
            @Mapping(target = "employee.id", source = "employeeId"),
            @Mapping(target = "period", source = "period"),
    })
    ReportModel requestReportSalesToModel(RequestReportDataSales requestReportDataSales);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "filePath", ignore = true),
            @Mapping(target = "generatedAt", ignore = true),
            @Mapping(target = "employee", ignore = true),
            @Mapping(target = "employee.id", source = "employeeId"),
            @Mapping(target = "period", source = "period"),
    })
    ReportModel requestReportPurchaseToModel(RequestReportDataPurchases requestReportDataPurchases);

    default DataReportModel<SalesModel> salesReportToModel(RequestReportDataSales requestReportDataSales) {

        SalesModel salesModel = SalesModel.builder()
                .id(requestReportDataSales.getIdModel())
                .build();

        return new DataReportModel<SalesModel>(
                requestReportDataSales.getCustomerName(),
                requestReportDataSales.getIdentificationCustomer(),
                salesModel
        );
    }

    default DataReportModel<PurchaseModel> purchaseReportToModel(RequestReportDataPurchases requestReportDataPurchases) {

        ProviderModel providerModel = new ProviderModel();
        providerModel.setId(requestReportDataPurchases.getIdProvider());

        PurchaseModel purchaseModel = new PurchaseModel();
        purchaseModel.setId(requestReportDataPurchases.getIdModel());
        purchaseModel.setProviderModel(providerModel);

        return new DataReportModel<PurchaseModel>(
                "",
                "",
                purchaseModel
        );
    }
}
