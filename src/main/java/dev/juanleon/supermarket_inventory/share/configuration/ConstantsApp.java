package dev.juanleon.supermarket_inventory.share.configuration;

import java.util.List;

public final class ConstantsApp {

    private ConstantsApp(){}

    public final static String PATH_UPLOAD_IMAGES_EMPLOYEES = "uploads/employees";
    public final static String PATH_UPLOAD_IMAGES_PRODUCTS = "uploads/products";
    public final static String PATH_UPLOAD_FILES_PDF_SALES = "uploads/reports/sales";
    public final static String PATH_UPLOAD_FILES_PDF_PURCHASES = "uploads/reports/purchases";
    public static final List<String> ALLOWED_IMAGE_EXTENSIONS = List.of("image/jpg", "image/jpeg", "image/png", "image/webp");
    public static final String WEBP = "webp";
    public static final String PDF = "pdf";
    public static final String TEMPLATE_REPORT_SALES = "report_sales";
    public static final String TEMPLATE_REPORT_PURCHASE = "report_purchases";
    public static final String SALES_REPORT_MODEL = "saleReportModel";
    public static final String PURCHASE_REPORT_MODEL = "purchaseReportModel";
    public static final String TYPE_SALES = "SALES";
    public static final String TYPE_PURCHASES = "PURCHASES";
}
