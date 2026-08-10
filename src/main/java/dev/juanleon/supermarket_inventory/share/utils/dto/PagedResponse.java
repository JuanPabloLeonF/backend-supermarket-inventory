package dev.juanleon.supermarket_inventory.share.utils.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record PagedResponse<T>(
        List<T> content,
        Integer pageNumber,
        Integer pageSize,
        Long totalElements,
        Integer totalPages,
        Boolean isLast
) {}
