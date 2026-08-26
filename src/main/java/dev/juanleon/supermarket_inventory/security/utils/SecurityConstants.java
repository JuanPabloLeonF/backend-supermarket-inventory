package dev.juanleon.supermarket_inventory.security.utils;

public final class SecurityConstants {

    private SecurityConstants(){}

    public static final String SECRET_KEY = "clave_ultra_secreta_super_segura_para_el_inventario_123456";
    public static final String AUTHORITIES = "authorities";
    public static final String PREFIX_ROLE = "ROLE_";
    public static final long TOKEN_EXPIRATION = 1000 * 60 * 60 * 24;
}
