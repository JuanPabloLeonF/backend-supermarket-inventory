package dev.juanleon.supermarket_inventory.sales.domain.services.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;

import java.util.UUID;

public interface IPostSalesServices {
    ResponseModel create(SalesModel salesModel, UUID employeeId);
}
