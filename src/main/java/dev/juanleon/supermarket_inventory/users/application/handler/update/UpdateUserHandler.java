package dev.juanleon.supermarket_inventory.users.application.handler.update;

import dev.juanleon.supermarket_inventory.users.domain.services.update.IUpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserHandler {
    private final IUpdateUserService iUpdateUserService;
}
