package dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.get;

import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.ISecurityProviderUser;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetUserService;

public class GetUserUseCase implements IGetUserService {

    private final ISecurityProviderUser iSecurityProviderUser;

    public GetUserUseCase(ISecurityProviderUser iSecurityProviderUser) {
        this.iSecurityProviderUser = iSecurityProviderUser;
    }

    @Override
    public String generatedToken(String email, String password) {
        return this.iSecurityProviderUser.generatedToken(email, password);
    }
}
