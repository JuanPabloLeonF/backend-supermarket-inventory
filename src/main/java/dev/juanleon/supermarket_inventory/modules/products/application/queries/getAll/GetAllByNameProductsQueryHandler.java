package dev.juanleon.supermarket_inventory.modules.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.modules.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.get.IGetProductsServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllByNameProductsQueryHandler implements IRequestHandler<GetAllByNameProductsQuery, PagedResponse<ResponseProductDto>> {

    private final IGetProductsServices iGetProductsServices;
    private final IMapperProductsApplication iMapperProductsApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseProductDto> handle(GetAllByNameProductsQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        PagedResponse<ProductModel> productModelPagedResponse = this.iGetProductsServices.getByName(data, request.name());

        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                productModelPagedResponse,
                this.iMapperProductsApplication::toDto
        );
    }

    @Override
    public Class<GetAllByNameProductsQuery> getRequestType() {
        return GetAllByNameProductsQuery.class;
    }
}
