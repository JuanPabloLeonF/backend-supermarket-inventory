package dev.juanleon.supermarket_inventory.share.files.utils;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class FilesUtil {

    private FilesUtil(){}

    public static String determineResourceType(String urlFile) {
        if (urlFile == null || urlFile.isBlank()) {
            return "raw";
        }

        String extension = extractExtension(urlFile).toLowerCase();

        return "webp".contains(extension) ? "image" : "raw";
    }

    public static String extractExtension(String urlFile) {
        int lastDotIndex = urlFile.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == urlFile.length() - 1) {
            return "";
        }
        return urlFile.substring(lastDotIndex + 1);
    }

    public static InputStream convertHtmlToPdf(String processedHtml) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(processedHtml, null);
            builder.toStream(os);
            builder.run();
            return new ByteArrayInputStream(os.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("Error generando PDF", e);
        }
    }

    public static String extractPublicIdFromUrl(String imageUrl) {
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("La URL de la imagen no puede estar vacía.");
        }

        try {
            String pathAfterUpload = imageUrl.substring(imageUrl.indexOf("/upload/") + 8);

            if (pathAfterUpload.startsWith("v") && pathAfterUpload.contains("/")) {
                pathAfterUpload = pathAfterUpload.substring(pathAfterUpload.indexOf("/") + 1);
            }

            int lastDotIndex = pathAfterUpload.lastIndexOf(".");
            if (lastDotIndex != -1) {
                pathAfterUpload = pathAfterUpload.substring(0, lastDotIndex);
            }

            return pathAfterUpload;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo extraer el public_id de la URL de Cloudinary: " + imageUrl, e);
        }
    }
}
