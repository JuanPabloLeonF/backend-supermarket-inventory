package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.queries.getAll.GetAllProviderQuery;
import dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy.GetByIdProviderQuery;
import dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy.GetByNameProviderQuery;
import dev.juanleon.supermarket_inventory.share.mediator.Mediator;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderRestController {

    private final Mediator mediator;

    @GetMapping
    public ResponseEntity<PagedResponse<ResponseProviderDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllProviderQuery query = new GetAllProviderQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProviderDto> getById(@PathVariable("id") UUID id) {
        GetByIdProviderQuery query = new GetByIdProviderQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/name")
    public ResponseEntity<ResponseProviderDto> getByName(
            @RequestParam String fullName
    ) {
        GetByNameProviderQuery query = new GetByNameProviderQuery(fullName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

}
