package dev.juanleon.supermarket_inventory.share.files.events;

public record FileCreatedEvent(
        String urlFile,
        String pathUpload
) {}
