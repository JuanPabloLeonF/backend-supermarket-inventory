package dev.juanleon.supermarket_inventory.modules.sales.domain.services.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;

public interface IPostSalesServices {
    ResponseModel create(SalesModel salesModel);
}
