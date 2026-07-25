package dev.juanleon.supermarket_inventory.products.domain.persistence.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface IGetProductsPersistence {
    ProductModel getById(UUID id);
    ProductModel getByCode(String code);
    PagedResponse<ProductModel> getAll(PaginationRequest paginationRequest);
    PagedResponse<ProductModel> getByCategories(PaginationRequest paginationRequest, String categoriesName);
    PagedResponse<ProductModel> getByName(PaginationRequest paginationRequest, String name);
    PagedResponse<ProductModel> getByActive(PaginationRequest paginationRequest, Boolean active);
    PagedResponse<ProductModel> getByStock(PaginationRequest paginationRequest, Integer stock);
    PagedResponse<ProductModel> getByPriceSale(PaginationRequest paginationRequest, BigDecimal priceSale);
    PagedResponse<ProductModel> getByPricePurchase(PaginationRequest paginationRequest, BigDecimal pricePurchase);
    PagedResponse<ProductModel> getByUnitMeasurement(PaginationRequest paginationRequest, String unitMeasurement);
    PagedResponse<ProductModel> getByCreatedAt(PaginationRequest paginationRequest, LocalDate createdAt);
    PagedResponse<ProductModel> getByUpdatedAt(PaginationRequest paginationRequest, LocalDate updatedAt);
}
