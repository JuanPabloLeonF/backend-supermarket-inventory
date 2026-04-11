package dev.juanleon.supermarket_inventory.files.infrastructure.exterior.adapter;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.files.domain.IFilesPersistence;
import dev.juanleon.supermarket_inventory.files.infrastructure.exceptions.NotFoundFileException;
import dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository.IFileUtils;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.InputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.File_DELETED_SUCCESSFULLY_BY_URL;
import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.PDF;
import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.SALES_REPORT_MODEL;


@Repository
@RequiredArgsConstructor
public class FilesAdapter implements IFilesPersistence {

    private final IFileUtils iFileUtils;
    private final TemplateEngine templateEngine;

    @Override
    public String createPdf(SaleReportModel saleReportModel, String pathUpload, String templateName) {
        saleReportModel.setCreatedAt(LocalDateTime.now().withNano(0));
        Context context = new Context();
        context.setVariable(SALES_REPORT_MODEL, saleReportModel);

        String htmlGenerated = templateEngine.process(templateName, context);

        InputStream pdfStream = iFileUtils.convertHtmlToPdf(htmlGenerated);

        String urlPdf = iFileUtils.generateUniqueFileName(templateName, PDF);
        Path uploadPath = iFileUtils.getUploadPath(pathUpload);
        iFileUtils.createDirectoriesIfNotExists(uploadPath);
        iFileUtils.saveFile(pdfStream, uploadPath.resolve(urlPdf));

        return urlPdf;
    }

    @Override
    public String createImage(InputFileDto inputFileDto, String pathUpload) {
        return this.iFileUtils.processAndSaveWebp(
                inputFileDto.getInputStream(),
                inputFileDto.getOriginalName(),
                pathUpload
        );
    }

    @Override
    public String updateImg(InputFileDto inputFileDto, String pathUpload, String urlImage) {

        return this.iFileUtils.findFile(urlImage, pathUpload)
                .map(path -> {

                    String newUrlImg = this.iFileUtils.processAndSaveWebp(
                            inputFileDto.getInputStream(),
                            inputFileDto.getOriginalName(),
                            pathUpload
                    );

                    this.iFileUtils.deleteFileByPath(path);

                    return newUrlImg;

                }).orElseThrow(() -> new NotFoundFileException(urlImage));
    }

    @Override
    public ResponseModel deleteFile(String urlImage, String pathUpload) {
        return this.iFileUtils.findFile(urlImage, pathUpload)
                .map(file -> {
                    this.iFileUtils.deleteFileByPath(file);
                    return new ResponseModel(File_DELETED_SUCCESSFULLY_BY_URL.format(urlImage));
                }).orElseThrow(() -> new NotFoundFileException(urlImage));
    }

    @Override
    public void validateContentType(String contentType, List<String> allowedExtensions) {
        this.iFileUtils.validateContentType(contentType, allowedExtensions);
    }
}
