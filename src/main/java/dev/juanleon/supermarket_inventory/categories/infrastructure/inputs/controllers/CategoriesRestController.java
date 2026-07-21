package dev.juanleon.supermarket_inventory.categories.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.categories.application.commands.delete.DeleteByIdCategoriesCommand;
import dev.juanleon.supermarket_inventory.categories.application.commands.post.CreateCategoriesCommand;
import dev.juanleon.supermarket_inventory.categories.application.commands.update.UpdateByIdCategoriesCommand;
import dev.juanleon.supermarket_inventory.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.queries.getAll.GetAllByNameCategoriesQuery;
import dev.juanleon.supermarket_inventory.categories.application.queries.getAll.GetAllCategoriesQuery;
import dev.juanleon.supermarket_inventory.categories.application.queries.getBy.GetByIdCategoriesQuery;
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
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesRestController {

    private final Mediator mediator;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCategoriesDto> getById(@PathVariable("id") UUID id) {
        GetByIdCategoriesQuery query = new GetByIdCategoriesQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping
    public ResponseEntity<PagedResponse<ResponseCategoriesDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllCategoriesQuery query = new GetAllCategoriesQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/name")
    public ResponseEntity<PagedResponse<ResponseCategoriesDto>> getAllByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String name
    ) {
        GetAllByNameCategoriesQuery query = new GetAllByNameCategoriesQuery(page, size, name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping
    public ResponseEntity<ResponseRequestDto> create(@Valid RequestCategoriesDto request) {
        CreateCategoriesCommand command = new CreateCategoriesCommand(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.mediator.dispatch(command));
    }

    @PostMapping("/updateById")
    public ResponseEntity<ResponseRequestDto> updateById(@Valid RequestUpdateCategoriesDto request) {
        UpdateByIdCategoriesCommand command = new UpdateByIdCategoriesCommand(request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequestDto> deleteById(@PathVariable("id") UUID id) {
        DeleteByIdCategoriesCommand command = new DeleteByIdCategoriesCommand(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }
}
