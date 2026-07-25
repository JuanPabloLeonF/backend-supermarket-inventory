package dev.juanleon.supermarket_inventory.products.domain.useCases.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.get.IGetProductsPersistence;
import dev.juanleon.supermarket_inventory.products.domain.services.get.IGetProductsServices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class GetProductsUseCases implements IGetProductsServices {

    private final IGetProductsPersistence iGetProductsPersistence;

    public GetProductsUseCases(IGetProductsPersistence iGetProductsPersistence) {
        this.iGetProductsPersistence = iGetProductsPersistence;
    }

    @Override
    public ProductModel getById(UUID id) {
        return this.iGetProductsPersistence.getById(id);
    }

    @Override
    public ProductModel getByCode(String code) {
        return this.iGetProductsPersistence.getByCode(code);
    }

    @Override
    public PagedResponse<ProductModel> getAll(PaginationRequest paginationRequest) {
        return this.iGetProductsPersistence.getAll(paginationRequest);
    }

    @Override
    public PagedResponse<ProductModel> getByCategories(PaginationRequest paginationRequest, String categoriesName) {
        return this.iGetProductsPersistence.getByCategories(paginationRequest, categoriesName);
    }

    @Override
    public PagedResponse<ProductModel> getByName(PaginationRequest paginationRequest, String name) {
        return this.iGetProductsPersistence.getByName(paginationRequest, name);
    }

    @Override
    public PagedResponse<ProductModel> getByActive(PaginationRequest paginationRequest, Boolean active) {
        return this.iGetProductsPersistence.getByActive(paginationRequest, active);
    }

    @Override
    public PagedResponse<ProductModel> getByStock(PaginationRequest paginationRequest, Integer stock) {
        return this.iGetProductsPersistence.getByStock(paginationRequest, stock);
    }

    @Override
    public PagedResponse<ProductModel> getByPriceSale(PaginationRequest paginationRequest, BigDecimal priceSale) {
        return this.iGetProductsPersistence.getByPriceSale(paginationRequest, priceSale);
    }

    @Override
    public PagedResponse<ProductModel> getByPricePurchase(PaginationRequest paginationRequest, BigDecimal pricePurchase) {
        return this.iGetProductsPersistence.getByPricePurchase(paginationRequest, pricePurchase);
    }

    @Override
    public PagedResponse<ProductModel> getByUnitMeasurement(PaginationRequest paginationRequest, String unitMeasurement) {
        return this.iGetProductsPersistence.getByUnitMeasurement(paginationRequest, unitMeasurement);
    }

    @Override
    public PagedResponse<ProductModel> getByCreatedAt(PaginationRequest paginationRequest, LocalDate createdAt) {
        return this.iGetProductsPersistence.getByCreatedAt(paginationRequest, createdAt);
    }

    @Override
    public PagedResponse<ProductModel> getByUpdatedAt(PaginationRequest paginationRequest, LocalDate updatedAt) {
        return this.iGetProductsPersistence.getByUpdatedAt(paginationRequest, updatedAt);
    }
}
