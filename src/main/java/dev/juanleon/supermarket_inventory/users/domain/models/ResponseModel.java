package dev.juanleon.supermarket_inventory.users.domain.models;

import java.time.LocalDateTime;

public record ResponseModel (String message, LocalDateTime data){
    public ResponseModel(String message, LocalDateTime data) {
        this.message = message;
        this.data = data;
    }
}
