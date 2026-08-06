package dev.juanleon.supermarket_inventory.files.events;

public record FileDeletedEvent(
        String urlFile,
        String pathUpload
) {
}
