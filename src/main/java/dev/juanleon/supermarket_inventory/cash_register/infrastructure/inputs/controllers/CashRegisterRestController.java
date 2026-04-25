package dev.juanleon.supermarket_inventory.cash_register.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.cash_register.application.commands.post.PostCashRegisterCommand;
import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.cash_register.application.dto.RequestEmployeeId;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getAll.GetAllCashRegisterQuery;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy.GetByEmployeeIdCashRegisterQuery;
import dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy.GetByIdCashRegisterQuery;
import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
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
    public ResponseEntity<PagedResponse<CashRegisterResponse>> getAll(@RequestBody PaginationRequest request) {
        GetAllCashRegisterQuery query = new GetAllCashRegisterQuery(request);
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

    @GetMapping("/employeeId")
    public ResponseEntity<PagedResponse<CashRegisterResponse>> getByEmployeeId(@Valid @RequestBody RequestEmployeeId request) {
        GetByEmployeeIdCashRegisterQuery query = new GetByEmployeeIdCashRegisterQuery(
                request.getEmployeeId(),
                request.getPaginationRequest()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping
    public ResponseEntity<ResponseRequestDto> create(@Valid @RequestBody CashRegisterRequest request) {
        PostCashRegisterCommand command = new PostCashRegisterCommand(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }
}
