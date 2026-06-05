package dev.juanleon.supermarket_inventory.sales.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesRequestDTO;
import dev.juanleon.supermarket_inventory.sales.application.mappers.IMapperSalesApplication;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.domain.services.post.IPostSalesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostSalesHandler implements IPostSalesHandler {

    private final IPostSalesServices iPostSalesServices;
    private final IMapperResponseApp iMapperResponseApp;
    private final IMapperSalesApplication iMapperSalesApplication;

    @Override
    @Transactional
    public ResponseRequestDto create(SalesRequestDTO salesRequestDTO, UUID employeeId) {
        SalesModel salesModel = this.iMapperSalesApplication.toModel(salesRequestDTO);
        return this.iMapperResponseApp.toResponse(this.iPostSalesServices.create(salesModel, employeeId));
    }
}
