package dev.juanleon.supermarket_inventory.modules.products.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.modules.products.application.handler.get.IGetProductsHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdProductsQueryHandler implements IRequestHandler<GetByIdProductsQuery, ResponseProductDto> {

    private final IGetProductsHandler iGetProductsHandler;

    @Override
    public ResponseProductDto handle(GetByIdProductsQuery request) {
        return this.iGetProductsHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdProductsQuery> getRequestType() {
        return GetByIdProductsQuery.class;
    }
}
