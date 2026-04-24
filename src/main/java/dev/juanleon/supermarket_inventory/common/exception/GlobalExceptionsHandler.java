package dev.juanleon.supermarket_inventory.common.exception;

import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.exceptions.NotFoundCashRegisterException;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NoCreateEmployeeOnDatabaseException;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import dev.juanleon.supermarket_inventory.files.infrastructure.exceptions.*;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.exceptions.ErrorTryingCreateReport;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.exceptions.NotFoundReportException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.EmailAlreadyExistsException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoCreateUserOnDatabaseException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoUpdateUserByIdException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionsHandler extends BuildResponseExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, String> erros = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });

        return this.buildResponse(HttpStatus.BAD_REQUEST, exception, erros);
    }

    //NOT FOUND 404
    @ExceptionHandler({
            NotFoundUserException.class,
            NoUpdateUserByIdException.class,
            NotFoundReportException.class,
            NotFoundFileException.class,
            NotFoundEmployeeException.class,
            NotFoundCashRegisterException.class
    })
    public ResponseEntity<ProblemDetail> handlerNotFoundException(Exception exception) {
        return this.buildResponse(HttpStatus.NOT_FOUND, exception);
    }

    //BAD REQUEST 400
    @ExceptionHandler({
            EmailAlreadyExistsException.class,
            ErrorFileTypeNotAllowedException.class,
            IllegalArgumentException.class,
            DataIntegrityViolationException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<ProblemDetail> handlerBadRequestException(Exception exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    //INTERNAL SERVER ERROR 500
    @ExceptionHandler({
            NoCreateUserOnDatabaseException.class,
            ErrorTryingCreateReport.class,
            ErrorTryingSaveFileException.class,
            ErrorTryingDeleteFileException.class,
            ErrorCreatedDirectoriesException.class,
            ErrorConvertingImageToWebpException.class,
            NoCreateEmployeeOnDatabaseException.class,
            NotFoundTypeRequestHandlerMediator.class
    })
    public ResponseEntity<ProblemDetail> handlerInternalServerErrorException(Exception exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}
