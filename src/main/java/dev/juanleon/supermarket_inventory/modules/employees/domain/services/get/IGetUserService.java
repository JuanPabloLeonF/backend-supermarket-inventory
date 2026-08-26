package dev.juanleon.supermarket_inventory.modules.employees.domain.services.get;


public interface IGetUserService {
    String generatedToken(String email, String password);
}
