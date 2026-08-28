package dev.juanleon.supermarket_inventory.modules.categories.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.post.IPostCategoriesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCategoriesCommandHandler implements IRequestHandler<CreateCategoriesCommand, ResponseRequestDto> {

    private final IPostCategoriesServices iPostCategoriesServices;
    private final IMapperCategoriesApplication iMapperCategoriesApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(CreateCategoriesCommand request) {
        RequestCategoriesDto dto = request.requestCategoriesDto();
        CategoriesModel categoriesModel = this.iMapperCategoriesApplication.toModel(dto);
        ResponseModel responseModel = this.iPostCategoriesServices.create(categoriesModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<CreateCategoriesCommand> getRequestType() {
        return CreateCategoriesCommand.class;
    }
}
