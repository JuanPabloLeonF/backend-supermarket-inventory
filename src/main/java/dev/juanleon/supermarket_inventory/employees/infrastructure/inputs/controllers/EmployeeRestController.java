package dev.juanleon.supermarket_inventory.employees.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.commands.delete.DeleteByIdEmployeeAndUserCommand;
import dev.juanleon.supermarket_inventory.employees.application.commands.post.RegisterEmployeeAndUserCommand;
import dev.juanleon.supermarket_inventory.employees.application.commands.update.UpdateByIdEmployeeAndUserCommand;
import dev.juanleon.supermarket_inventory.employees.application.commands.update.UpdateByIdImgCommand;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.*;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;
import dev.juanleon.supermarket_inventory.employees.application.queries.getAll.GetAllEmployeeQuery;
import dev.juanleon.supermarket_inventory.employees.application.queries.getBy.GetByHireDateEmployeeQuery;
import dev.juanleon.supermarket_inventory.employees.application.queries.getBy.GetByIdEmployeeQuery;
import dev.juanleon.supermarket_inventory.employees.application.queries.getBy.GetByNameAndLastNameEmployeeQuery;
import dev.juanleon.supermarket_inventory.employees.application.queries.getBy.GetByPositionQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final Mediator mediator;

    @GetMapping
    public ResponseEntity<PagedResponse<ResponseEmployeeDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetAllEmployeeQuery query = new GetAllEmployeeQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEmployeeDto> getById(@PathVariable("id") UUID id) {
        GetByIdEmployeeQuery query = new GetByIdEmployeeQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/nameandlastname")
    public ResponseEntity<PagedResponse<ResponseEmployeeDto>> getByNameAndLastName(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetByNameAndLastNameEmployeeQuery query = new GetByNameAndLastNameEmployeeQuery(
                name,
                lastName,
                page,
                size
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/position")
    public ResponseEntity<PagedResponse<ResponseEmployeeDto>> getByPosition(
            @RequestParam(defaultValue = "") String position,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetByPositionQuery query = new GetByPositionQuery(position, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/hiredate")
    public ResponseEntity<PagedResponse<ResponseEmployeeDto>> getByHireDate(
            @RequestParam(defaultValue = "") LocalDateTime hireDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        GetByHireDateEmployeeQuery query = new GetByHireDateEmployeeQuery(hireDate, page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseRequestDto> registerEmployeeAndUser(@Valid @ModelAttribute RequestEmployeeDto requestEmployeeDto) {
        RegisterEmployeeAndUserCommand command = new RegisterEmployeeAndUserCommand(requestEmployeeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.mediator.dispatch(command));
    }

    @PutMapping("/updateById")
    public ResponseEntity<ResponseRequestDto> updateByIdEmployeeAndUser(@Valid @RequestBody RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser) {
        UpdateByIdEmployeeAndUserCommand command = new UpdateByIdEmployeeAndUserCommand(requestUpdateEmployeeAndUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

    @PutMapping("/image")
    public ResponseEntity<ResponseRequestDto> updateByIdImg(@Valid @ModelAttribute RequestUpdateImage request) {
        UpdateByIdImgCommand command = new UpdateByIdImgCommand(request.getFileImg(), request.getId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }

    @DeleteMapping("/{idEmployee}/subid/{idUser}")
    public ResponseEntity<ResponseRequestDto> deleteByIdEmployeeAndUser(
            @PathVariable("idEmployee") UUID idEmployee,
            @PathVariable("idUser") UUID idUser
    ) {
        DeleteByIdEmployeeAndUserCommand command = new DeleteByIdEmployeeAndUserCommand(idEmployee, idUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(command));
    }
}
