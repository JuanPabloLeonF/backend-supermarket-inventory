package dev.juanleon.supermarket_inventory.modules.sales.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.sales.application.mappers.IMapperSalesApplication;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.services.post.IPostSalesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateSalesCommandHandler implements IRequestHandler<CreateSalesCommand, ResponseRequestDto> {

    private final IPostSalesServices iPostSalesServices;
    private final IMapperResponseApp iMapperResponseApp;
    private final IMapperSalesApplication iMapperSalesApplication;

    @Override
    @Transactional
    public ResponseRequestDto handle(CreateSalesCommand request) {
        SalesModel salesModel = this.iMapperSalesApplication.toModel(request.requestSalesDto());
        return this.iMapperResponseApp.toResponse(this.iPostSalesServices.create(salesModel));
    }

    @Override
    public Class<CreateSalesCommand> getRequestType() {
        return CreateSalesCommand.class;
    }
}
