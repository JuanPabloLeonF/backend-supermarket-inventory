package dev.juanleon.supermarket_inventory.reports.application.commands.delete;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.reports.application.handler.delete.IDeleteReportHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteByIdReportCommandHandler implements IRequestHandler<DeleteByIdReportCommand, ResponseRequestDto> {

    private final IDeleteReportHandler iDeleteReportHandler;

    @Override
    public ResponseRequestDto handle(DeleteByIdReportCommand request) {
        return this.iDeleteReportHandler.deleteById(request.id());
    }

    @Override
    public Class<DeleteByIdReportCommand> getRequestType() {
        return DeleteByIdReportCommand.class;
    }
}
