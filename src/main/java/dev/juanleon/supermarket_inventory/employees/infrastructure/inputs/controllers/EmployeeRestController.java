package dev.juanleon.supermarket_inventory.employees.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.application.dto.RequestNameAndLastName;
import dev.juanleon.supermarket_inventory.employees.application.dto.ResponseEmployeeDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEmployeeDto> getById(@PathVariable("id")UUID id) {
        GetByIdEmployeeQuery query = new GetByIdEmployeeQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/nameandlastname")
    public ResponseEntity<PagedResponse<ResponseEmployeeDto>> getByNameAndLastName(@Valid @RequestBody RequestNameAndLastName request) {
        GetByNameAndLastNameEmployeeQuery query = new GetByNameAndLastNameEmployeeQuery(
                request.getName(),
                request.getLastName(),
                request.getPaginationRequest()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<PagedResponse<ResponseEmployeeDto>> getByPosition(@PathVariable("position") String position, @RequestBody PaginationRequest request) {
        GetByPositionQuery query = new GetByPositionQuery(position, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/hiredate/{hireDate}")
    public ResponseEntity<PagedResponse<ResponseEmployeeDto>> getByHireDate(@PathVariable("hireDate") LocalDateTime hireDate, @RequestBody PaginationRequest request) {
        GetByHireDateEmployeeQuery query = new GetByHireDateEmployeeQuery(hireDate, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }
}
