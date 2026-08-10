package dev.juanleon.supermarket_inventory.share.files.utils;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;
import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorConvertingImageToWebpException;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Objects;
import java.util.UUID;

public final class FilesUtil {

    private FilesUtil(){}

    public static Path stringToPath(String urlPath) {
        return Path.of(urlPath);
    }

    public static String generateUniqueFileName(String originalName, String extension) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(originalName));
        String nameWithoutExtension = fileName.contains(".")
                ? fileName.substring(0, fileName.lastIndexOf('.'))
                : fileName;
        return UUID.randomUUID() + "_" + nameWithoutExtension + "." + extension;
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

    public static InputStream convertFileImgToWebp(InputStream inputStream) {
        try {
            byte[] webpBytes = ImmutableImage.loader()
                    .fromStream(inputStream)
                    .bytes(WebpWriter.DEFAULT);
            return new ByteArrayInputStream(webpBytes);
        } catch (Exception exception) {
            throw new ErrorConvertingImageToWebpException(exception.getMessage());
        }
    }
}
