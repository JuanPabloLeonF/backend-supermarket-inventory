package dev.juanleon.supermarket_inventory.common.utils.mappers;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperPaginationApp {

    default Pageable toPageable(PaginationRequest request) {
        if (request == null) {
            return PageRequest.of(0, 10);
        }
        return PageRequest.of(request.page(), request.size());
    }

    default <M,R> PagedResponse<R> pageResponseToPageResponseTypeResponse(PagedResponse<M> pagedResponse, Function<M, R> mapperFunction) {

        List<R> content = pagedResponse.content().stream()
                .map(mapperFunction)
                .toList();

        return PagedResponse.<R>builder()
                .content(content)
                .pageNumber(pagedResponse.pageNumber())
                .pageSize(pagedResponse.pageSize())
                .totalElements(pagedResponse.totalElements())
                .totalPages(pagedResponse.totalPages())
                .isLast(pagedResponse.isLast())
                .build();
    }

    default <E, M> PagedResponse<M> pagetoPagedResponse(Page<E> page, Function<E, M> mapperFunction) {

        List<M> content = page.getContent().stream()
                .map(mapperFunction)
                .toList();

        return PagedResponse.<M>builder()
                .content(content)
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isLast(page.isLast())
                .build();
    }
}
