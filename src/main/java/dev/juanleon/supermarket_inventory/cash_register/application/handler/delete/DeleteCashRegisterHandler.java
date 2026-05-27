package dev.juanleon.supermarket_inventory.cash_register.application.handler.delete;

import dev.juanleon.supermarket_inventory.cash_register.domain.services.delete.IDeleteCashRegisterService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCashRegisterHandler implements IDeleteCashRegisterHandler {

    private final IDeleteCashRegisterService iDeleteCashRegisterService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto deleteById(UUID id) {
        return this.iMapperResponseApp.toResponse(this.iDeleteCashRegisterService.deleteById(id));
    }
}
