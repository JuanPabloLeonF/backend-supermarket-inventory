package dev.juanleon.supermarket_inventory.reports.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.reports.application.commands.post.CreateSalesReportCommand;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestCreateSales;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestGetByPeriodReport;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.reports.application.queries.getAll.GetAllReportQuery;
import dev.juanleon.supermarket_inventory.reports.application.queries.getBy.GetByIdReportQuery;
import dev.juanleon.supermarket_inventory.reports.application.queries.getBy.GetByPeriodReportQuery;
import dev.juanleon.supermarket_inventory.reports.application.queries.getBy.GetByYearReportQuery;
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
    public ResponseEntity<PagedResponse<ResponseReport>> getAll(@RequestBody PaginationRequest paginationRequest) {
        GetAllReportQuery query = new GetAllReportQuery(paginationRequest);
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
    public ResponseEntity<PagedResponse<ResponseReport>> getByPeriod(@RequestBody RequestGetByPeriodReport request) {
        GetByPeriodReportQuery query = new GetByPeriodReportQuery(request.getPeriod(), request.getPaginationRequest());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<PagedResponse<ResponseReport>> getByYear(@PathVariable("year") String year, @RequestBody PaginationRequest paginationRequest) {
        GetByYearReportQuery query = new GetByYearReportQuery(year, paginationRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping
    public ResponseEntity<ResponseRequestDto> createSale(@RequestBody RequestCreateSales request) {
        CreateSalesReportCommand command = new CreateSalesReportCommand(
                request.getRequestReportDto(),
                request.getRequestReportSalesData()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }
}
