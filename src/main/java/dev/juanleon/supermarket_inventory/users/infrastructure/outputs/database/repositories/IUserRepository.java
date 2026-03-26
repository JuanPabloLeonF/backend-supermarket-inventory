package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    public List<UserEntity> findByName(String name);
    public List<UserEntity> findByLastName(String lastName);
}
