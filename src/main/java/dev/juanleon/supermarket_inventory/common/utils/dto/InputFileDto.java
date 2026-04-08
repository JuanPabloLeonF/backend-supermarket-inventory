package dev.juanleon.supermarket_inventory.common.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InputFileDto {
    private String originalName;
    private String contentType;
    private long size;
    private InputStream inputStream;
}
