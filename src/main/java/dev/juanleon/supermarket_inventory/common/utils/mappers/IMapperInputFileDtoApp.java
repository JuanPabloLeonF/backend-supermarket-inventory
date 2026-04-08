package dev.juanleon.supermarket_inventory.common.utils.mappers;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface IMapperInputFileDtoApp {

    default InputFileDto toDto(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("El archivo no puede ser nulo");
        }

        try {
            return InputFileDto
                    .builder()
                    .originalName(file.getOriginalFilename())
                    .size(file.getSize())
                    .contentType(file.getContentType())
                    .inputStream(file.getInputStream())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
