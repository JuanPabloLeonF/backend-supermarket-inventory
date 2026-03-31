package dev.juanleon.supermarket_inventory.users.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.commands.delete.DeleteByIdUserCommand;
import dev.juanleon.supermarket_inventory.users.application.commands.post.CreateUserCommand;
import dev.juanleon.supermarket_inventory.users.application.commands.update.UpdateByIdUserCommand;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.queries.getAll.GetAllUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByIdUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByLastNameUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByNameUserQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final Mediator mediator;

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getAll() {
        GetAllUserQuery query = new GetAllUserQuery();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mediator.dispatch(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getById(@PathVariable("id") UUID id) {
        GetByIdUserQuery query = new GetByIdUserQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mediator.dispatch(query));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ResponseUserDto>> getByName(@PathVariable("name") String name) {
        GetByNameUserQuery query = new GetByNameUserQuery(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mediator.dispatch(query));
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<ResponseUserDto>> getByLastName(@PathVariable("lastName") String lastName) {
        GetByLastNameUserQuery query = new GetByLastNameUserQuery(lastName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mediator.dispatch(query));
    }

    @PostMapping
    public ResponseEntity<ResponseRequestDto> create(@Valid @RequestBody RequestUserDto requestUserDto) {
        CreateUserCommand command = new CreateUserCommand(requestUserDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mediator.dispatch(command));
    }

    @PutMapping
    public ResponseEntity<ResponseRequestDto> updateById(@Valid @RequestBody RequestUpdateUserDto requestUpdateUserDto) {
        UpdateByIdUserCommand command = new UpdateByIdUserCommand(requestUpdateUserDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mediator.dispatch(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseRequestDto> deleteById(@PathVariable("id") UUID id) {
        DeleteByIdUserCommand command = new DeleteByIdUserCommand(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mediator.dispatch(command));
    }
}
