package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.entities.ProviderEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IProviderRepository extends JpaRepository<ProviderEntity, UUID> {

    @Override
    @NonNull
    Page<ProviderEntity> findAll(@NonNull Pageable pageable);

    Optional<ProviderEntity> findByFullName(String name);
}
