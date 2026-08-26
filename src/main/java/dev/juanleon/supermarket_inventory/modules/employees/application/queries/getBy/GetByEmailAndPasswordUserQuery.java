package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.employees.application.dto.requets.RequestLoginDto;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseTokenDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;

public record GetByEmailAndPasswordUserQuery(
        RequestLoginDto requestLoginDto
) implements IRequest<ResponseTokenDto> {
}
