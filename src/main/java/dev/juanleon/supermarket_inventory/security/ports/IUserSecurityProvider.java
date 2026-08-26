package dev.juanleon.supermarket_inventory.security.ports;

import dev.juanleon.supermarket_inventory.security.authentication.SecurityUserModel;

public interface IUserSecurityProvider {
    SecurityUserModel getByEmail(String email);
}
