package dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import dev.juanleon.supermarket_inventory.files.infrastructure.exceptions.ErrorTryingSaveFileException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.*;
import java.util.Optional;

import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.WEBP;


@Component
@RequiredArgsConstructor
public class FileUtils implements IFileUtils {

    @Override
    public void saveFile(InputStream inputStream, Path pathUpload) {
        try {

            Files.copy(
                    inputStream,
                    pathUpload,
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (Exception exception) {
            throw new ErrorTryingSaveFileException(exception.getMessage());
        }
    }

    @Override
    public Optional<File> findFile(String fileName, String pathUpload) {
        if (fileName == null || fileName.isBlank()) {
            return Optional.empty();
        }

        Path filePath = this.getUploadPath(pathUpload)
                .resolve(fileName)
                .normalize();

        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            return Optional.of(filePath.toFile());
        }

        return Optional.empty();
    }

    @Override
    public InputStream convertHtmlToPdf(String processedHtml) {
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

    @Override
    public String processAndSaveWebp(InputStream input, String originalName, String pathUpload) {
        InputStream inputStreamImg = this.convertFileImgToWebp(input);
        String urlImg = this.generateUniqueFileName(originalName, WEBP);
        Path uploadPath = this.getUploadPath(pathUpload);
        this.createDirectoriesIfNotExists(uploadPath);
        this.saveFile(inputStreamImg, uploadPath.resolve(urlImg));
        return urlImg;
    }
}