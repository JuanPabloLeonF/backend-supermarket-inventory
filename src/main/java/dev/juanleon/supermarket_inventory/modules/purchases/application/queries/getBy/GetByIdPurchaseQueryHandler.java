package dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.ResponsePurchaseDto;
import dev.juanleon.supermarket_inventory.modules.purchases.application.mappers.IMapperPurchaseApplication;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.services.get.IGetPurchaseService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdPurchaseQueryHandler implements IRequestHandler<GetByIdPurchaseQuery, ResponsePurchaseDto> {

    private final IGetPurchaseService iGetPurchaseService;
    private final IMapperPurchaseApplication iMapperPurchaseApplication;

    @Override
    public ResponsePurchaseDto handle(GetByIdPurchaseQuery request) {
        return this.iMapperPurchaseApplication.toResponse(this.iGetPurchaseService.getById(request.id()));
    }

    @Override
    public Class<GetByIdPurchaseQuery> getRequestType() {
        return GetByIdPurchaseQuery.class;
    }
}
