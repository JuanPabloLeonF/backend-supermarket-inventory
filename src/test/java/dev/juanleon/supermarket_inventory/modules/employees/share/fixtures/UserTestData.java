package dev.juanleon.supermarket_inventory.modules.employees.share.fixtures;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.share.utils.enums.Roles;

import java.time.LocalDateTime;

public final class UserTestData {

    private UserTestData(){}

    public static final UserEntity userSave1  = UserEntity.builder()
            .name("juan")
            .lastName("leon")
            .password("contrasena123")
            .rol(Roles.USER)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .email("juan@gmail.com")
            .build();

    public static final UserEntity userSave2  = UserEntity.builder()
            .name("camilo")
            .lastName("hernandez")
            .password("1234567")
            .rol(Roles.ADMIN)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .email("garcia@gmail.com")
            .build();
}
