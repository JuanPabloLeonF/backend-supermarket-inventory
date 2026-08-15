package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.modules.providers.application.commands.delete.DeleteByIdProviderCommand;
import dev.juanleon.supermarket_inventory.modules.providers.application.commands.update.UpdateByIdProviderCommand;
import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.modules.providers.application.queries.getAll.GetAllProviderQuery;
import dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy.GetByIdProviderQuery;
import dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy.GetByNameProviderQuery;
import dev.juanleon.supermarket_inventory.modules.providers.application.commands.post.CreateProviderCommand;
import dev.juanleon.supermarket_inventory.modules.providers.application.dto.RequestProviderDto;
import dev.juanleon.supermarket_inventory.share.mediator.Mediator;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
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

    @PostMapping("/create")
    public ResponseEntity<ResponseRequestDto> create(@RequestBody RequestProviderDto requestProviderDto) {
        CreateProviderCommand command = new CreateProviderCommand(requestProviderDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.mediator.dispatch(command));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseRequestDto> updateById(
            @PathVariable("id") UUID id,
            @RequestBody RequestProviderDto requestProviderDto
    ) {
        UpdateByIdProviderCommand command = new UpdateByIdProviderCommand(id, requestProviderDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseRequestDto> deleteById(@PathVariable("id") UUID id) {
        DeleteByIdProviderCommand command = new DeleteByIdProviderCommand(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

}
