package dev.juanleon.supermarket_inventory.modules.reports.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.modules.reports.application.commands.post.CreatePurchaseReportCommand;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportDataPurchases;
import dev.juanleon.supermarket_inventory.share.mediator.Mediator;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.reports.application.commands.delete.DeleteByIdReportCommand;
import dev.juanleon.supermarket_inventory.modules.reports.application.commands.post.CreateSalesReportCommand;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportDataSales;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;
import dev.juanleon.supermarket_inventory.modules.reports.application.queries.getAll.GetAllReportQuery;
import dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy.GetByIdReportQuery;
import dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy.GetByPeriodReportQuery;
import dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy.GetByYearReportQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportRestController {

    private final Mediator mediator;

    @GetMapping
    public ResponseEntity<PagedResponse<ResponseReport>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllReportQuery query = new GetAllReportQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseReport> getById(@PathVariable("id") UUID id) {
        GetByIdReportQuery query = new GetByIdReportQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/period")
    public ResponseEntity<PagedResponse<ResponseReport>> getByPeriod(
            @RequestParam String period,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetByPeriodReportQuery query = new GetByPeriodReportQuery(period, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/year")
    public ResponseEntity<PagedResponse<ResponseReport>> getByYear(
            @RequestParam String year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetByYearReportQuery query = new GetByYearReportQuery(year, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping("/createsales")
    public ResponseEntity<ResponseRequestDto> createSale(@Valid @RequestBody RequestReportDataSales request) {
        CreateSalesReportCommand command = new CreateSalesReportCommand(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

    @PostMapping("/createpurchase")
    public ResponseEntity<ResponseRequestDto> createPurchase(@Valid @RequestBody RequestReportDataPurchases request) {
        CreatePurchaseReportCommand command = new CreatePurchaseReportCommand(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequestDto> deleteById(@PathVariable("id") UUID id) {
        DeleteByIdReportCommand command = new DeleteByIdReportCommand(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }
}
