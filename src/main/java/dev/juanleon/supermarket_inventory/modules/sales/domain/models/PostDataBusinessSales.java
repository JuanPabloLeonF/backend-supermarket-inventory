package dev.juanleon.supermarket_inventory.modules.sales.domain.models;


import java.util.Map;
import java.util.UUID;

public record PostDataBusinessSales(
        SalesModel salesModel,
        Map<UUID, Integer> newStockMap
) {
}
