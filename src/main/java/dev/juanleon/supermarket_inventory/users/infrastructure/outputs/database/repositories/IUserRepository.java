package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findByName(String name);
    List<UserEntity> findByLastName(String lastName);
    Optional<UserEntity> findByEmail(String email);
}
