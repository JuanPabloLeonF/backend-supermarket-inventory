package dev.juanleon.supermarket_inventory.sales.domain.persistence.post;

import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;

public interface IPostSalesPersistence {
    String create(SalesModel salesModel);
}
