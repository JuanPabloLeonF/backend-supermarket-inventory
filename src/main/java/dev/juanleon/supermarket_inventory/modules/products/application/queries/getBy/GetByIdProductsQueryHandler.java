package dev.juanleon.supermarket_inventory.modules.products.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.modules.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.get.IGetProductsServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdProductsQueryHandler implements IRequestHandler<GetByIdProductsQuery, ResponseProductDto> {

    private final IGetProductsServices iGetProductsServices;
    private final IMapperProductsApplication iMapperProductsApplication;

    @Override
    public ResponseProductDto handle(GetByIdProductsQuery request) {
        return this.iMapperProductsApplication.toDto(this.iGetProductsServices.getById(request.id()));
    }

    @Override
    public Class<GetByIdProductsQuery> getRequestType() {
        return GetByIdProductsQuery.class;
    }
}
