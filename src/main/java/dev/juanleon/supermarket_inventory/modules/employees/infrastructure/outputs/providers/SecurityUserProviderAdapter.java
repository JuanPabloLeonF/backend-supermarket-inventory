package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers.IMapperUserInfrastructure;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundUserException;
import dev.juanleon.supermarket_inventory.security.authentication.SecurityUserModel;
import dev.juanleon.supermarket_inventory.security.ports.IUserSecurityProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUserProviderAdapter implements IUserSecurityProvider {

    private final IUserRepository iUserRepository;
    private final IMapperUserInfrastructure iMapperUserInfrastructure;

    @Override
    public SecurityUserModel getByEmail(String email) {
        return this.iUserRepository.findByEmail(email)
                .map(this.iMapperUserInfrastructure::toSecurityModel)
                .orElseThrow(() -> new NotFoundUserException(email));
    }
}
