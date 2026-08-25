package dev.juanleon.supermarket_inventory.security.authentication;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "clave_ultra_secreta_super_segura_para_el_inventario_123456";
    private static final long TOKEN_EXPIRATION = 1000 * 60 * 60 * 24;
    private static final String AUTHORITIES = "authorities";

    public String generatedToken(UserDetails userDetails) {
        Map<String, Object> claims = Map.of(
                AUTHORITIES,
                userDetails
                        .getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList()
        );
        return generateToken(claims, userDetails.getUsername());
    }


    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts
                .builder()
                .signWith(getSigningKey())
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                .compact();
    }

    private Claims getAllClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException exception) {
            throw new RuntimeException("Invalid, expired or malformed JWT token", exception);
        }
    }

    public String getSubject(String token) {
        return getClaim(token, Claims::getSubject);
    }

//    public List<String> getAuthorities(String token) {
//        return getClaim(token, claims -> claims.get(AUTHORITIES, String.class);
//    }

    private <T> T getClaim(String token, Function<Claims, T> claimMapper) {
        return claimMapper.apply(getAllClaims(token));
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
