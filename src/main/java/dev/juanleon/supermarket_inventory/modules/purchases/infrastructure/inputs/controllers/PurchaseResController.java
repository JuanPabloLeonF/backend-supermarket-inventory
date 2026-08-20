package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.modules.purchases.application.commands.post.CreatePurchaseCommand;
import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.RequestPurchaseDto;
import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.ResponsePurchaseDto;
import dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getAll.GetAllByIdEmployeePurchaseQuery;
import dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getAll.GetAllByIdProviderPurchaseQuery;
import dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getAll.GetAllPurchaseQuery;
import dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getBy.GetByIdPurchaseQuery;
import dev.juanleon.supermarket_inventory.share.mediator.Mediator;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseResController {

    private final Mediator mediator;

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePurchaseDto> getById(@PathVariable("id") UUID id) {
        GetByIdPurchaseQuery query = new GetByIdPurchaseQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping
    public ResponseEntity<PagedResponse<ResponsePurchaseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllPurchaseQuery query = new GetAllPurchaseQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/idprovider")
    public ResponseEntity<PagedResponse<ResponsePurchaseDto>> getAllByIdProvider(
            @RequestParam UUID idProvider,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByIdProviderPurchaseQuery query = new GetAllByIdProviderPurchaseQuery(idProvider, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/idemployee")
    public ResponseEntity<PagedResponse<ResponsePurchaseDto>> getAllByIdEmployee(
            @RequestParam UUID idEmployee,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllByIdEmployeePurchaseQuery query = new GetAllByIdEmployeePurchaseQuery(idEmployee, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseRequestDto> create(@Valid @RequestBody RequestPurchaseDto request) {
        CreatePurchaseCommand command = new CreatePurchaseCommand(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.mediator.dispatch(command));
    }
}
