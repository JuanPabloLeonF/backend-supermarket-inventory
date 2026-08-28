package dev.juanleon.supermarket_inventory.modules.categories.application.commands.update;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.update.IUpdateCategoriesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateByIdCategoriesCommandHandler implements IRequestHandler<UpdateByIdCategoriesCommand, ResponseRequestDto> {

    private final IUpdateCategoriesServices iUpdateCategoriesServices;
    private final IMapperCategoriesApplication iMapperCategoriesApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(UpdateByIdCategoriesCommand request) {
        RequestUpdateCategoriesDto dto = request.requestUpdateCategoriesDto();
        CategoriesModel categoriesModel = this.iMapperCategoriesApplication.toModel(dto);
        ResponseModel responseModel = this.iUpdateCategoriesServices.updateById(categoriesModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<UpdateByIdCategoriesCommand> getRequestType() {
        return UpdateByIdCategoriesCommand.class;
    }
}
