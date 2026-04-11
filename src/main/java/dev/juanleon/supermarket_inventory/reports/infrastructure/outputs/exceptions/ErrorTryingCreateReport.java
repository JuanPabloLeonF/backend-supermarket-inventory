package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.REPORT_NOT_CREATED_BY_ERROR;

public class ErrorTryingCreateReport extends RuntimeException {
    public ErrorTryingCreateReport() {
        super(REPORT_NOT_CREATED_BY_ERROR.getMessage());
    }
}
