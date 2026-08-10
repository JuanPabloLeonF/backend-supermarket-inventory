package dev.juanleon.supermarket_inventory.modules.categories.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.categories.application.handler.post.IPostCategoriesHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCategoriesCommandHandler implements IRequestHandler<CreateCategoriesCommand, ResponseRequestDto> {

    private final IPostCategoriesHandler iPostCategoriesHandler;

    @Override
    public ResponseRequestDto handle(CreateCategoriesCommand request) {
        return this.iPostCategoriesHandler.create(request.requestCategoriesDto());
    }

    @Override
    public Class<CreateCategoriesCommand> getRequestType() {
        return CreateCategoriesCommand.class;
    }
}
