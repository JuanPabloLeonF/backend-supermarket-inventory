package dev.juanleon.supermarket_inventory.modules.products.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.modules.products.application.handler.get.IGetProductsHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByCodeProductsQueryHandler implements IRequestHandler<GetByCodeProductsQuery, ResponseProductDto> {

    private final IGetProductsHandler iGetProductsHandler;

    @Override
    public ResponseProductDto handle(GetByCodeProductsQuery request) {
        return this.iGetProductsHandler.getByCode(request.code());
    }

    @Override
    public Class<GetByCodeProductsQuery> getRequestType() {
        return GetByCodeProductsQuery.class;
    }
}
