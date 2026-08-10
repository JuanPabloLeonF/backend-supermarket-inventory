package dev.juanleon.supermarket_inventory.modules.sales.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.share.mediator.Mediator;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.commands.post.CreateSalesCommand;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.RequestSalesDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.queries.getAll.*;
import dev.juanleon.supermarket_inventory.modules.sales.application.queries.getBy.GetByIdSalesQuery;
import dev.juanleon.supermarket_inventory.modules.sales.application.queries.getBy.GetByNumberSalesQuery;
import jakarta.validation.Valid;
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
    public ResponseEntity<PagedResponse<ResponseSalesDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllSalesQuery query = new GetAllSalesQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<PagedResponse<ResponseSalesDto>> getAllByEmployeeId(
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
    public ResponseEntity<PagedResponse<ResponseSalesDto>> getAllByDateSale(
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
    public ResponseEntity<PagedResponse<ResponseSalesDto>> getAllByMethodPayment(
            @RequestParam String methodPayment,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByMethodPaymentSalesQuery query = new GetAllByMethodPaymentSalesQuery(methodPayment, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/discount")
    public ResponseEntity<PagedResponse<ResponseSalesDto>> getAllByDiscount(
            @RequestParam
            @DecimalMin(value = "0.00")
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
    public ResponseEntity<ResponseSalesDto> getById(@PathVariable("id") UUID id) {
        GetByIdSalesQuery query = new GetByIdSalesQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/number-sale/{numberSale}")
    public ResponseEntity<ResponseSalesDto> getByNumberSale(@PathVariable("numberSale") UUID numberSale) {
        GetByNumberSalesQuery query = new GetByNumberSalesQuery(numberSale);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseRequestDto> create(@Valid @RequestBody RequestSalesDto requestSalesDto) {
        CreateSalesCommand command = new CreateSalesCommand(requestSalesDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }
}
