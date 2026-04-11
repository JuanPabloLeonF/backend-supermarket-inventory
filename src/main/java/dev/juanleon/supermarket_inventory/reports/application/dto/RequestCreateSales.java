package dev.juanleon.supermarket_inventory.reports.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCreateSales {

    @Valid
    @NotNull(message = "requestReportDto is required")
    private RequestReportDto requestReportDto;

    @Valid
    @NotNull(message = "requestReportSalesData is required")
    private RequestReportSalesData requestReportSalesData;
}
