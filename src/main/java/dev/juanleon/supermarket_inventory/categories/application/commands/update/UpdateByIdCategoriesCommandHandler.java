package dev.juanleon.supermarket_inventory.categories.application.commands.update;

import dev.juanleon.supermarket_inventory.categories.application.handler.update.IUpdateCategoriesHandler;
import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateByIdCategoriesCommandHandler implements IRequestHandler<UpdateByIdCategoriesCommand, ResponseRequestDto> {

    private final IUpdateCategoriesHandler iUpdateCategoriesHandler;

    @Override
    public ResponseRequestDto handle(UpdateByIdCategoriesCommand request) {
        return this.iUpdateCategoriesHandler.updateById(request.requestUpdateCategoriesDto());
    }

    @Override
    public Class<UpdateByIdCategoriesCommand> getRequestType() {
        return UpdateByIdCategoriesCommand.class;
    }
}
