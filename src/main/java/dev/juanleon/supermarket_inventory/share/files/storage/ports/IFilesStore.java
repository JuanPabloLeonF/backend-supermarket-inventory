package dev.juanleon.supermarket_inventory.share.files.storage.ports;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;

import java.io.InputStream;

public interface IFilesStore {
    String uploadImage(InputFileDto inputFileDto, String folderName);
    void deleteFile(String urlFile);
    String uploadPdf(InputStream inputStream, String folderName);
}
