package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseTokenDto;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetUserService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByEmailAndPasswordUserQueryHandler implements IRequestHandler<GetByEmailAndPasswordUserQuery, ResponseTokenDto> {

    private final IGetUserService iGetUserService;

    @Override
    public ResponseTokenDto handle(GetByEmailAndPasswordUserQuery request) {

        String token = this.iGetUserService.generatedToken(
                request.requestLoginDto().getEmail(),
                request.requestLoginDto().getPassword()
        );

        return new ResponseTokenDto(token);
    }

    @Override
    public Class<GetByEmailAndPasswordUserQuery> getRequestType() {
        return GetByEmailAndPasswordUserQuery.class;
    }
}
