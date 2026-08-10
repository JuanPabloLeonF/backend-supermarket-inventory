package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.entities.ProductEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface IProductRepository extends JpaRepository<ProductEntity, UUID> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"categoriesEntity"})
    Optional<ProductEntity> findById(@NonNull UUID id);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findAll(@NonNull Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Optional<ProductEntity> findByCode(String code);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByCategoriesEntity_Name(String name, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByName(String name, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByStock(Integer stock, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByActive(Boolean active, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByPriceSale(BigDecimal priceSale, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByPricePurchase(BigDecimal pricePurchase, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByUnitMeasurement(String unitMeasurement, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByCreatedAtGreaterThanEqual(LocalDate createdAt, Pageable pageable);

    @EntityGraph(attributePaths = {"categoriesEntity"})
    Page<ProductEntity> findByUpdatedAtGreaterThanEqual(LocalDate updatedAt, Pageable pageable);
}
