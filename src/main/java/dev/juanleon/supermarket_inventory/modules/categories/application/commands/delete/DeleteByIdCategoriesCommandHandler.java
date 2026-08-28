package dev.juanleon.supermarket_inventory.modules.categories.application.commands.delete;

import dev.juanleon.supermarket_inventory.modules.categories.domain.services.delete.IDeleteCategoriesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteByIdCategoriesCommandHandler implements IRequestHandler<DeleteByIdCategoriesCommand, ResponseRequestDto> {

    private final IDeleteCategoriesServices iDeleteCategoriesServices;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(DeleteByIdCategoriesCommand request) {
        ResponseModel responseModel = this.iDeleteCategoriesServices.deleteById(request.id());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<DeleteByIdCategoriesCommand> getRequestType() {
        return DeleteByIdCategoriesCommand.class;
    }
}
