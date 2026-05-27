package dev.juanleon.supermarket_inventory.cash_register.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.cash_register.application.commands.delete.DeleteCashRegisterCommand;
import dev.juanleon.supermarket_inventory.cash_register.application.commands.post.PostCashRegisterCommand;
import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getAll.GetAllCashRegisterQuery;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy.GetByEmployeeIdCashRegisterQuery;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy.GetByIdCashRegisterQuery;
import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cash-register")
@RequiredArgsConstructor
public class CashRegisterRestController {

    private final Mediator mediator;

    @GetMapping
    public ResponseEntity<PagedResponse<CashRegisterResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllCashRegisterQuery query = new GetAllCashRegisterQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CashRegisterResponse> getById(@PathVariable("id") UUID id) {
        GetByIdCashRegisterQuery query = new GetByIdCashRegisterQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<PagedResponse<CashRegisterResponse>> getByEmployeeId(
            @PathVariable("employeeId") UUID employeeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetByEmployeeIdCashRegisterQuery query = new GetByEmployeeIdCashRegisterQuery(
                employeeId,
                page,
                size
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseRequestDto> create(@Valid @RequestBody CashRegisterRequest request) {
        PostCashRegisterCommand command = new PostCashRegisterCommand(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequestDto> deleteById(@PathVariable("id") UUID id) {
        DeleteCashRegisterCommand command = new DeleteCashRegisterCommand(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }
}
