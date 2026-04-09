package dev.juanleon.supermarket_inventory.files.infrastructure.exterior.adapter;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.files.domain.IFilesPersistence;
import dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository.IFileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.nio.file.Path;

@Repository
@RequiredArgsConstructor
public class FilesAdapter implements IFilesPersistence {

    private final IFileUtils iFileUtils;

    @Override
    public String createPdf(InputFileDto inputFileDto, String pathUpload) {
        //AQUI VA LA LOGICA PARA GENERAR UN PDF CON UNA PLANTILLA HTML LO HARE MAS TARDE!!
        return null;
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

        String newUrlImg = this.iFileUtils.processAndSaveWebp(
                inputFileDto.getInputStream(),
                inputFileDto.getOriginalName(),
                pathUpload
        );

        try {
            Path oldFilePath = this.iFileUtils.getUploadPath(pathUpload).resolve(urlImage).normalize();
            this.iFileUtils.deleteFile(oldFilePath);
        } catch (Exception e) {
            // Opcional: Loggear que el viejo no se pudo borrar, pero el proceso sigue
        }

        return newUrlImg;
    }

    @Override
    public ResponseModel deleteFile(String urlImage, String pathUpload) {
        Path filePath = this.iFileUtils
                .getUploadPath(pathUpload)
                .resolve(urlImage)
                .normalize();
        this.iFileUtils.deleteFile(filePath);
        return new ResponseModel("Archivo eliminado correctamente");
    }
}
