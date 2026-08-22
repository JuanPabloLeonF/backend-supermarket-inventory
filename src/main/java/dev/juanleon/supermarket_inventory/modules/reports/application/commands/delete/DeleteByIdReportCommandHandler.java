package dev.juanleon.supermarket_inventory.modules.reports.application.commands.delete;

import dev.juanleon.supermarket_inventory.modules.reports.domain.services.delete.IDeleteReportService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperResponseApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteByIdReportCommandHandler implements IRequestHandler<DeleteByIdReportCommand, ResponseRequestDto> {

    private final IDeleteReportService iDeleteReportService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    @Transactional
    public ResponseRequestDto handle(DeleteByIdReportCommand request) {
        ResponseModel responseModel = this.iDeleteReportService.deleteById(request.id());
        return this.iMapperResponseApp.toResponse(responseModel);
    }

    @Override
    public Class<DeleteByIdReportCommand> getRequestType() {
        return DeleteByIdReportCommand.class;
    }
}
