package dev.juanleon.supermarket_inventory.security.providers;

import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.ISecurityProviderUser;
import dev.juanleon.supermarket_inventory.security.authentication.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSecurityProviderAdapter implements ISecurityProviderUser {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String generatedToken(String email, String password) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                ));

        return this.jwtService.generateToken(authentication);
    }
}
