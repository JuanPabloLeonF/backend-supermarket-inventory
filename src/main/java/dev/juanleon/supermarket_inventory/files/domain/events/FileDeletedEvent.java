package dev.juanleon.supermarket_inventory.files.domain.events;

public record FileDeletedEvent(
        String urlFile,
        String pathUpload
) {
}
