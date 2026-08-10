package dev.juanleon.supermarket_inventory.modules.reports.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.delete.IDeleteReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteReportHandler implements IDeleteReportHandler {

    private final IDeleteReportService iDeleteReportService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto deleteById(UUID id) {
        ResponseModel responseModel = this.iDeleteReportService.deleteById(id);
        return this.iMapperResponseApp.toResponse(responseModel);
    }
}
