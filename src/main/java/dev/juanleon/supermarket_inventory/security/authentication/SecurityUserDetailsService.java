package dev.juanleon.supermarket_inventory.security.authentication;

import dev.juanleon.supermarket_inventory.security.ports.IUserSecurityProvider;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final IUserSecurityProvider iUserSecurityProvider;

    @NullMarked
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.iUserSecurityProvider.getByEmail(username);
    }
}
