package dev.juanleon.supermarket_inventory.common.utils.dto;

import lombok.Builder;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.BAD_REQUEST_VALIDATED_PAGINATION_NUMBER;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.BAD_REQUEST_VALIDATED_PAGINATION_SIZE;

@Builder
public record PaginationRequest(Integer page, Integer size) {

    public PaginationRequest {
        page = (page == null) ? 0 : page;
        size = (size == null) ? 10 : size;

        if (page < 0) {
            throw new IllegalArgumentException(BAD_REQUEST_VALIDATED_PAGINATION_NUMBER.getMessage());
        }

        if (size < 1) {
            throw new IllegalArgumentException(BAD_REQUEST_VALIDATED_PAGINATION_SIZE.getMessage());
        }
    }
}
