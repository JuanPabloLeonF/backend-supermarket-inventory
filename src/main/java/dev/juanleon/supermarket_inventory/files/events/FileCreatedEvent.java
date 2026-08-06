package dev.juanleon.supermarket_inventory.files.events;

public record FileCreatedEvent(
        String urlFile,
        String pathUpload
) {}
