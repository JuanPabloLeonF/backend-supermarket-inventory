package dev.juanleon.supermarket_inventory.share.utils.validations;

public class ValidationsGenerics {

    public static void validatedFieldString(String fielValue, String fielName) {
        if (fielValue == null || fielValue.isBlank()) {
            throw new IllegalArgumentException("El campo " + fielName + " no puede estar vacio");
        }
    }
}
