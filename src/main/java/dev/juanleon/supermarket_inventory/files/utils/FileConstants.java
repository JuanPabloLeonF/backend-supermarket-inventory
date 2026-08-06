package dev.juanleon.supermarket_inventory.files.utils;

import java.util.List;

public final class FileConstants {

    private FileConstants(){}

    public static final List<String> ALLOWED_IMAGE_EXTENSIONS = List.of("image/jpg", "image/jpeg", "image/png", "image/webp");
    public static final String WEBP = "webp";
    public static final String PDF = "pdf";
    public static final String TEMPLATE_REPORT_SALES = "report_sales";
    public static final String SALES_REPORT_MODEL = "saleReportModel";
}
