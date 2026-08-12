package dev.juanleon.supermarket_inventory.modules.reports.domain.ports;

import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;

import java.util.UUID;

public interface ISaleProviderReport {
    SalesModel getSaleById(UUID saleId, UUID employeeId);
}
