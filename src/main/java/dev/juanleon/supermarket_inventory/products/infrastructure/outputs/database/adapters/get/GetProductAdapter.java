package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.get.IGetProductsPersistence;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.entities.ProductEntity;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.mappers.IMapperProductInfrastructure;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.repositories.IProductRepository;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions.NotFoundProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetProductAdapter implements IGetProductsPersistence {

    private final IProductRepository iProductRepository;
    private final IMapperProductInfrastructure iMapperProductInfrastructure;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public ProductModel getById(UUID id) {
        return this.iProductRepository.findById(id)
                .map(this.iMapperProductInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundProductException(id));
    }

    @Override
    public ProductModel getByCode(String code) {
        return this.iProductRepository.findByCode(code)
                .map(this.iMapperProductInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundProductException(code));
    }

    @Override
    public PagedResponse<ProductModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByCategories(PaginationRequest paginationRequest, String categoriesName) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByCategoriesEntity_Name(categoriesName, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByName(PaginationRequest paginationRequest, String name) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByName(name, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByActive(PaginationRequest paginationRequest, Boolean active) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByActive(active, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByStock(PaginationRequest paginationRequest, Integer stock) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByStock(stock, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByPriceSale(PaginationRequest paginationRequest, Double priceSale) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByPriceSale(priceSale, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByPricePurchase(PaginationRequest paginationRequest, Double pricePurchase) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByPricePurchase(pricePurchase, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByUnitMeasurement(PaginationRequest paginationRequest, String unitMeasurement) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByUnitMeasurement(unitMeasurement, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByCreatedAt(PaginationRequest paginationRequest, LocalDate createdAt) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByCreatedAtGreaterThanEqual(createdAt, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ProductModel> getByUpdatedAt(PaginationRequest paginationRequest, LocalDate updatedAt) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProductEntity> pageEntities = this.iProductRepository.findByUpdatedAtGreaterThanEqual(updatedAt, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(pageEntities, this.iMapperProductInfrastructure::toModel);
    }
}
