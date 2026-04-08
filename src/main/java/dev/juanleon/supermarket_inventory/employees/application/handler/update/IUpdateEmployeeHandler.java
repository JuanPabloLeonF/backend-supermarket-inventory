package dev.juanleon.supermarket_inventory.employees.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.employees.application.dto.requets.RequestUpdateEmployeeAndUser;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface IUpdateEmployeeHandler {
    ResponseRequestDto updateByIdEmployeeAndUser(RequestUpdateEmployeeAndUser requestUpdateEmployeeAndUser);
    ResponseRequestDto updateByIdImage(MultipartFile fileImg, UUID id);
}
