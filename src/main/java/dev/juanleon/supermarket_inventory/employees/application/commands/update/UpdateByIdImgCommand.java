package dev.juanleon.supermarket_inventory.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record UpdateByIdImgCommand(MultipartFile fileImg, UUID id) implements IRequest<ResponseRequestDto> {}
