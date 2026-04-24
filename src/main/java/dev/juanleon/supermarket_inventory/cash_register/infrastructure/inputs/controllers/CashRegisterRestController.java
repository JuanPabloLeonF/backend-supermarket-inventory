package dev.juanleon.supermarket_inventory.cash_register.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.cash_register.application.dto.RequestEmployeeId;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getAll.GetAllCashRegisterQuery;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy.GetByEmployeeIdCashRegisterQuery;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy.GetByIdCashRegisterQuery;
import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cashRegister")
@RequiredArgsConstructor
public class CashRegisterRestController {

    private final Mediator mediator;

    @GetMapping
    public ResponseEntity<PagedResponse<CashRegisterResponse>> getAll(@Valid @RequestBody PaginationRequest request) {
        GetAllCashRegisterQuery query = new GetAllCashRegisterQuery(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CashRegisterResponse> getById(@PathVariable("id")UUID id) {
        GetByIdCashRegisterQuery query = new GetByIdCashRegisterQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/employeeId")
    public ResponseEntity<PagedResponse<CashRegisterResponse>> getByNameAndLastName(@Valid @RequestBody RequestEmployeeId request) {
        GetByEmployeeIdCashRegisterQuery query = new GetByEmployeeIdCashRegisterQuery(
                request.getEmployeeId(),
                request.getPaginationRequest()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }
}
