package dev.juanleon.supermarket_inventory.common.utils.dto;

import java.time.LocalDateTime;

public record ResponseModel(String message, LocalDateTime dateTime) {
    public ResponseModel(String message) {
        this(message, LocalDateTime.now());
    }
}
