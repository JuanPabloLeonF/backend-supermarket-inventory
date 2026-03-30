package dev.juanleon.supermarket_inventory.users.domain.services.delete;

import dev.juanleon.supermarket_inventory.users.domain.models.ResponseModel;

import java.util.UUID;

public interface IDeleteUserService {
    ResponseModel deleteById(UUID id);
}
