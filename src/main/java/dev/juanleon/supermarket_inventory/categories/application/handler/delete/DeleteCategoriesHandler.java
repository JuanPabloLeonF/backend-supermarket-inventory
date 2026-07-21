package dev.juanleon.supermarket_inventory.categories.application.handler.delete;

import dev.juanleon.supermarket_inventory.categories.domain.services.delete.IDeleteCategoriesServices;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCategoriesHandler implements IDeleteCategoriesHandler {

    private final IDeleteCategoriesServices iDeleteCategoriesServices;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto deleteById(UUID id) {
        ResponseModel responseModel = this.iDeleteCategoriesServices.deleteById(id);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
