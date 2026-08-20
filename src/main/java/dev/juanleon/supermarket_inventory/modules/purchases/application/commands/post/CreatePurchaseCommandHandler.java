package dev.juanleon.supermarket_inventory.modules.purchases.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.purchases.application.mappers.IMapperPurchaseApplication;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.services.post.IPostPurchaseService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreatePurchaseCommandHandler implements IRequestHandler<CreatePurchaseCommand, ResponseRequestDto> {

    private final IPostPurchaseService iPostPurchaseService;
    private final IMapperPurchaseApplication iMapperPurchaseApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(CreatePurchaseCommand request) {
        PurchaseModel purchaseModel = this.iMapperPurchaseApplication.toModel(request.requestPurchaseDto());
        ResponseModel responseModel = this.iPostPurchaseService.create(purchaseModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<CreatePurchaseCommand> getRequestType() {
        return CreatePurchaseCommand.class;
    }
}
