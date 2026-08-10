package dev.juanleon.supermarket_inventory.share.files.events;

public record FileDeletedEvent(
        String urlFile,
        String pathUpload
) {
}
