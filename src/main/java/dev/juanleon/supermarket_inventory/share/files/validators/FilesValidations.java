package dev.juanleon.supermarket_inventory.share.files.validators;

import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorFileTypeNotAllowedException;

import java.util.List;

public final class FilesValidations {

    private FilesValidations(){}

    public static void validateContentType(String contentType, List<String> allowedTypes) {
        if (contentType == null || !allowedTypes.contains(contentType)) {
            throw new ErrorFileTypeNotAllowedException(contentType);
        }
    }
}
