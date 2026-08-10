package dev.juanleon.supermarket_inventory.modules.reports.infrastructure.outputs.exceptions;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.REPORT_NOT_FOUND_BY_ID;

public class NotFoundReportException extends RuntimeException {
    public NotFoundReportException(UUID id) {
        super(REPORT_NOT_FOUND_BY_ID.format(id));
    }
}
