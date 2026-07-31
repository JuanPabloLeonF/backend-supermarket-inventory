package dev.juanleon.supermarket_inventory.files.domain.events;

public record FileCreatedEvent(
        String urlFile,
        String pathUpload
) {}
