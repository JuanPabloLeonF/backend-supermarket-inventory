package dev.juanleon.supermarket_inventory.products.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.products.domain.services.delete.IDeleteProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteProductHandler implements IDeleteProductHandler {

    private final IDeleteProductService iDeleteProductService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto deleteById(UUID id) {
        ResponseModel responseModel = this.iDeleteProductService.deleteById(id);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
