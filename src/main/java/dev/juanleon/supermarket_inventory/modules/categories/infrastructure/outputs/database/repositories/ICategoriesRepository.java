package dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.entities.CategoriesEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICategoriesRepository extends JpaRepository<CategoriesEntity, UUID> {

    @Override
    @NonNull
    Page<CategoriesEntity> findAll(@NonNull Pageable pageable);

    Page<CategoriesEntity> findByName(String name, Pageable pageable);


}
