package dev.juanleon.supermarket_inventory.modules.employees.application.commands.update;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record UpdateByIdImgCommand(MultipartFile fileImg, UUID id) implements IRequest<ResponseRequestDto> {}
