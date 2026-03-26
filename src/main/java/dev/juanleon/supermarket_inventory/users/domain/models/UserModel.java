package dev.juanleon.supermarket_inventory.users.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserModel(
        UUID id,
        String name,
        String lastName,
        String email,
        String password,
        String rol,
        Boolean isActive,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
