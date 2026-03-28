package dev.juanleon.supermarket_inventory.users.domain.models;

import java.time.LocalDateTime;

public record ResponseModel(String message, LocalDateTime dateTime) {
    public ResponseModel(String message) {
        this(message, LocalDateTime.now());
    }
}
