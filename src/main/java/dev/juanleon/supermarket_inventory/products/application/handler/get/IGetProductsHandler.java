package dev.juanleon.supermarket_inventory.products.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface IGetProductsHandler {
    ResponseProductDto getById(UUID id);
    ResponseProductDto getByCode(String code);
    PagedResponse<ResponseProductDto> getAll(PaginationRequest paginationRequest);
    PagedResponse<ResponseProductDto> getByCategories(PaginationRequest paginationRequest, String categoriesName);
    PagedResponse<ResponseProductDto> getByName(PaginationRequest paginationRequest, String name);
    PagedResponse<ResponseProductDto> getByActive(PaginationRequest paginationRequest, Boolean active);
    PagedResponse<ResponseProductDto> getByStock(PaginationRequest paginationRequest, Integer stock);
    PagedResponse<ResponseProductDto> getByPriceSale(PaginationRequest paginationRequest, BigDecimal priceSale);
    PagedResponse<ResponseProductDto> getByPricePurchase(PaginationRequest paginationRequest, BigDecimal pricePurchase);
    PagedResponse<ResponseProductDto> getByUnitMeasurement(PaginationRequest paginationRequest, String unitMeasurement);
    PagedResponse<ResponseProductDto> getByCreatedAt(PaginationRequest paginationRequest, LocalDate createdAt);
    PagedResponse<ResponseProductDto> getByUpdatedAt(PaginationRequest paginationRequest, LocalDate updatedAt);
}
