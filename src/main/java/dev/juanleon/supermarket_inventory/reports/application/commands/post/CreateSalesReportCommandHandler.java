package dev.juanleon.supermarket_inventory.reports.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.reports.application.handler.post.IPostReportHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSalesReportCommandHandler implements IRequestHandler<CreateSalesReportCommand, ResponseRequestDto> {

    private final IPostReportHandler iPostReportHandler;

    @Override
    public ResponseRequestDto handle(CreateSalesReportCommand request) {
        return this.iPostReportHandler.createSale(
                request.requestReportDto(),
                request.requestReportSalesData()
        );
    }

    @Override
    public Class<CreateSalesReportCommand> getRequestType() {
        return CreateSalesReportCommand.class;
    }
}
