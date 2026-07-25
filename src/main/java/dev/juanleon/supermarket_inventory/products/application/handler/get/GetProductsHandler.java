package dev.juanleon.supermarket_inventory.products.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.services.get.IGetProductsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetProductsHandler implements IGetProductsHandler {

    private final IGetProductsServices iGetProductsServices;
    private final IMapperProductsApplication iMapperProductsApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public ResponseProductDto getById(UUID id) {
        return this.iMapperProductsApplication.toDto(this.iGetProductsServices.getById(id));
    }

    @Override
    public ResponseProductDto getByCode(String code) {
        return this.iMapperProductsApplication.toDto(this.iGetProductsServices.getByCode(code));
    }

    @Override
    public PagedResponse<ResponseProductDto> getAll(PaginationRequest paginationRequest) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getAll(paginationRequest);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByCategories(PaginationRequest paginationRequest, String categoriesName) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByCategories(paginationRequest, categoriesName);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByName(PaginationRequest paginationRequest, String name) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByName(paginationRequest, name);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByActive(PaginationRequest paginationRequest, Boolean active) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByActive(paginationRequest, active);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByStock(PaginationRequest paginationRequest, Integer stock) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByStock(paginationRequest, stock);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByPriceSale(PaginationRequest paginationRequest, BigDecimal priceSale) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByPriceSale(paginationRequest, priceSale);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByPricePurchase(PaginationRequest paginationRequest, BigDecimal pricePurchase) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByPricePurchase(paginationRequest, pricePurchase);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByUnitMeasurement(PaginationRequest paginationRequest, String unitMeasurement) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByUnitMeasurement(paginationRequest, unitMeasurement);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByCreatedAt(PaginationRequest paginationRequest, LocalDate createdAt) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByCreatedAt(paginationRequest, createdAt);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }

    @Override
    public PagedResponse<ResponseProductDto> getByUpdatedAt(PaginationRequest paginationRequest, LocalDate updatedAt) {
        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByUpdatedAt(paginationRequest, updatedAt);
        return this.iMapperPaginationApp
                .pageResponseToPageResponseTypeResponse(
                        productModelPagedResponse,
                        this.iMapperProductsApplication::toDto
                );
    }
}
