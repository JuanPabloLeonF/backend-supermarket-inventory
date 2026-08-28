package dev.juanleon.supermarket_inventory.modules.products.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.modules.products.application.mappers.IMapperProductsApplication;
import dev.juanleon.supermarket_inventory.modules.products.domain.services.get.IGetProductsServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByCodeProductsQueryHandler implements IRequestHandler<GetByCodeProductsQuery, ResponseProductDto> {

    private final IGetProductsServices iGetProductsServices;
    private final IMapperProductsApplication iMapperProductsApplication;

    @Override
    public ResponseProductDto handle(GetByCodeProductsQuery request) {
        return this.iMapperProductsApplication.toDto(this.iGetProductsServices.getByCode(request.code()));
    }

    @Override
    public Class<GetByCodeProductsQuery> getRequestType() {
        return GetByCodeProductsQuery.class;
    }
}
