package dev.juanleon.supermarket_inventory.categories.application.handler.post;

import dev.juanleon.supermarket_inventory.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.services.post.IPostCategoriesServices;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostCategoriesHandler implements IPostCategoriesHandler {

    private final IPostCategoriesServices iPostCategoriesServices;
    private final IMapperCategoriesApplication iMapperCategoriesApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto create(RequestCategoriesDto requestCategoriesDto) {
        CategoriesModel categoriesModel = this.iMapperCategoriesApplication.toModel(requestCategoriesDto);
        ResponseModel responseModel = this.iPostCategoriesServices.create(categoriesModel);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
