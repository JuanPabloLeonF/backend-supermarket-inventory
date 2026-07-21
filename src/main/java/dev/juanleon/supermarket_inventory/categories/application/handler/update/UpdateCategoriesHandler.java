package dev.juanleon.supermarket_inventory.categories.application.handler.update;

import dev.juanleon.supermarket_inventory.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.services.update.IUpdateCategoriesServices;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateCategoriesHandler implements IUpdateCategoriesHandler {

    private final IUpdateCategoriesServices iUpdateCategoriesServices;
    private final IMapperCategoriesApplication iMapperCategoriesApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto updateById(RequestUpdateCategoriesDto requestUpdateCategoriesDto) {
        CategoriesModel categoriesModel = this.iMapperCategoriesApplication.toModel(requestUpdateCategoriesDto);
        ResponseModel responseModel = this.iUpdateCategoriesServices.updateById(categoriesModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
