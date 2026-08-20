package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.entities.PurchaseEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IPurchaseRepository extends JpaRepository<PurchaseEntity, UUID> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {
            "employeeEntity",
            "employeeEntity.userEntity",
            "providerEntity",
            "purchaseDetailsEntityList",
            "purchaseDetailsEntityList.productEntity",
            "purchaseDetailsEntityList.productEntity.categoriesEntity"
    }
    )
    Optional<PurchaseEntity> findById(@NonNull UUID uuid);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {
            "employeeEntity",
            "employeeEntity.userEntity",
            "providerEntity",
            "purchaseDetailsEntityList",
            "purchaseDetailsEntityList.productEntity",
            "purchaseDetailsEntityList.productEntity.categoriesEntity"
    }
    )
    Page<PurchaseEntity> findAll(@NonNull Pageable pageable);

    @EntityGraph(attributePaths = {
            "employeeEntity",
            "employeeEntity.userEntity",
            "providerEntity",
            "purchaseDetailsEntityList",
            "purchaseDetailsEntityList.productEntity",
            "purchaseDetailsEntityList.productEntity.categoriesEntity"
    }
    )
    Page<PurchaseEntity> findByEmployeeEntity_Id(UUID id, Pageable pageable);

    @EntityGraph(attributePaths = {
            "employeeEntity",
            "employeeEntity.userEntity",
            "providerEntity",
            "purchaseDetailsEntityList",
            "purchaseDetailsEntityList.productEntity",
            "purchaseDetailsEntityList.productEntity.categoriesEntity"
    }
    )
    Page<PurchaseEntity> findByProviderEntity_Id(UUID id, Pageable pageable);
}
