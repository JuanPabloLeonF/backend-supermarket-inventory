package dev.juanleon.supermarket_inventory.sales.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;
import dev.juanleon.supermarket_inventory.sales.application.queries.getAll.*;
import dev.juanleon.supermarket_inventory.sales.application.queries.getBy.GetByIdSalesQuery;
import dev.juanleon.supermarket_inventory.sales.application.queries.getBy.GetByNumberSalesQuery;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@Validated
public class SalesRestController {

    private final Mediator mediator;

    @GetMapping
    public ResponseEntity<PagedResponse<SalesResponseDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllSalesQuery query = new GetAllSalesQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<PagedResponse<SalesResponseDTO>> getAllByEmployeeId(
            @PathVariable("employeeId") UUID employeeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByEmployeeIdQuery query = new GetAllByEmployeeIdQuery(employeeId, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/date")
    public ResponseEntity<PagedResponse<SalesResponseDTO>> getAllByDateSale(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            LocalDateTime dateSale,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByDateSaleQuery query = new GetAllByDateSaleQuery(dateSale, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/method-payment")
    public ResponseEntity<PagedResponse<SalesResponseDTO>> getAllByMethodPayment(
            @RequestParam String methodPayment,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByMethodPaymentSalesQuery query = new GetAllByMethodPaymentSalesQuery(methodPayment, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/status")
    public ResponseEntity<PagedResponse<SalesResponseDTO>> getAllByStatus(
            @RequestParam String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByStatusSalesQuery query = new GetAllByStatusSalesQuery(status, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/discount")
    public ResponseEntity<PagedResponse<SalesResponseDTO>> getAllByDiscount(
            @RequestParam
            @DecimalMin(value = "0.00", inclusive = true)
            @Digits(integer = 10, fraction = 2)
            BigDecimal discount,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByDiscountSalesQuery query = new GetAllByDiscountSalesQuery(discount, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SalesResponseDTO> getById(@PathVariable("id") UUID id) {
        GetByIdSalesQuery query = new GetByIdSalesQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/number-sale/{numberSale}")
    public ResponseEntity<SalesResponseDTO> getByNumberSale(@PathVariable("numberSale") UUID numberSale) {
        GetByNumberSalesQuery query = new GetByNumberSalesQuery(numberSale);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }
}
