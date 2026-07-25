package dev.juanleon.supermarket_inventory.products.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.commands.post.CreateProductCommand;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductDto;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByActiveProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByCategoriesProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByCreatedAtProductQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByNameProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByPricePurchaseProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByPriceSaleProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByStockProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByUnitMeasurementProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllByUpdatedAtProductQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getAll.GetAllProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getBy.GetByCodeProductsQuery;
import dev.juanleon.supermarket_inventory.products.application.queries.getBy.GetByIdProductsQuery;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResController {

    private final Mediator mediator;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDto> getById(@PathVariable("id") UUID id) {
        GetByIdProductsQuery query = new GetByIdProductsQuery(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/code")
    public ResponseEntity<ResponseProductDto> getByCode(@RequestParam String code) {
        GetByCodeProductsQuery query = new GetByCodeProductsQuery(code);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping
    public ResponseEntity<PagedResponse<ResponseProductDto>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllProductsQuery query = new GetAllProductsQuery(page, size);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/active")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByActive(
            @RequestParam Boolean active,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByActiveProductsQuery query = new GetAllByActiveProductsQuery(page, size, active);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/categories")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByCategories(
            @RequestParam String categoriesName,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByCategoriesProductsQuery query = new GetAllByCategoriesProductsQuery(page, size, categoriesName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/name")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByNameProductsQuery query = new GetAllByNameProductsQuery(page, size, name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/stock")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByStock(
            @RequestParam Integer stock,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByStockProductsQuery query = new GetAllByStockProductsQuery(page, size, stock);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/pricesale")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByPriceSale(
            @RequestParam
            @DecimalMin(value = "0.00", inclusive = true)
            @Digits(integer = 10, fraction = 2)
            BigDecimal priceSale,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByPriceSaleProductsQuery query = new GetAllByPriceSaleProductsQuery(page, size, priceSale);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/pricepurchase")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByPricePurchase(
            @RequestParam
            @DecimalMin(value = "0.00", inclusive = true)
            @Digits(integer = 10, fraction = 2)
            BigDecimal pricePurchase,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByPricePurchaseProductsQuery query = new GetAllByPricePurchaseProductsQuery(page, size, pricePurchase);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/unitmeasurement")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByUnitMeasurement(
            @RequestParam String unitMeasurement,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByUnitMeasurementProductsQuery query = new GetAllByUnitMeasurementProductsQuery(page, size, unitMeasurement);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/createdat")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByCreatedAt(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate createdAt,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByCreatedAtProductQuery query = new GetAllByCreatedAtProductQuery(page, size, createdAt);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @GetMapping("/updatedat")
    public ResponseEntity<PagedResponse<ResponseProductDto>> getByUpdatedAt(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate updatedAt,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        GetAllByUpdatedAtProductQuery query = new GetAllByUpdatedAtProductQuery(page, size, updatedAt);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mediator.dispatch(query));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseRequestDto> create(@Valid @RequestBody RequestProductDto request) {
        CreateProductCommand command = new CreateProductCommand(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.mediator.dispatch(command));
    }
}
