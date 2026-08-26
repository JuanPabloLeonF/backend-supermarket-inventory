package dev.juanleon.supermarket_inventory.modules.employees.domain.ports;

public interface ISecurityProviderUser {
    String generatedToken(String email, String password);
}
