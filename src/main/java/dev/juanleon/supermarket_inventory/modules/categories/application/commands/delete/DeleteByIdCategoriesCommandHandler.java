package dev.juanleon.supermarket_inventory.modules.categories.application.commands.delete;

import dev.juanleon.supermarket_inventory.modules.categories.application.handler.delete.IDeleteCategoriesHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdCategoriesCommandHandler implements IRequestHandler<DeleteByIdCategoriesCommand, ResponseRequestDto> {

    private final IDeleteCategoriesHandler iDeleteCategoriesHandler;

    @Override
    public ResponseRequestDto handle(DeleteByIdCategoriesCommand request) {
        return this.iDeleteCategoriesHandler.deleteById(request.id());
    }

    @Override
    public Class<DeleteByIdCategoriesCommand> getRequestType() {
        return DeleteByIdCategoriesCommand.class;
    }
}
