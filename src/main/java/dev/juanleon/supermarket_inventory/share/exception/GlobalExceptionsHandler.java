package dev.juanleon.supermarket_inventory.share.exception;

import dev.juanleon.supermarket_inventory.modules.cash_register.infrastructure.outputs.exceptions.NotFoundCashRegisterException;
import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.exceptions.NotFoundCategoriesException;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NoCreateEmployeeOnDatabaseException;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.NotFoundProductException;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.ProductsContainsDuplicateException;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.ProductsFollowingAreInactivesException;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.ProductsFollowingNotExistException;
import dev.juanleon.supermarket_inventory.modules.reports.infrastructure.outputs.exceptions.ErrorTryingCreateReport;
import dev.juanleon.supermarket_inventory.modules.reports.infrastructure.outputs.exceptions.NotFoundReportException;
import dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.exceptions.NotFoundSalesException;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.EmailAlreadyExistsException;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NoCreateUserOnDatabaseException;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NoUpdateUserByIdException;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundUserException;
import dev.juanleon.supermarket_inventory.share.files.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tools.jackson.databind.exc.InvalidFormatException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.INVALID_ENUM_VALUE;

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

    // VALID ENUMS 404
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetail> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {

        if (exception.getCause() instanceof InvalidFormatException invalidFormatException
                && invalidFormatException.getTargetType().isEnum()) {

            String field = invalidFormatException.getPath().getFirst().getPropertyName();

            Object[] values = invalidFormatException.getTargetType().getEnumConstants();

            return this.buildResponse(
                    INVALID_ENUM_VALUE.format(
                            invalidFormatException.getValue(),
                            field,
                            Arrays.toString(values)
                    ),
                    exception);
        }

        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    //NOT FOUND 404
    @ExceptionHandler({
            NotFoundUserException.class,
            NoUpdateUserByIdException.class,
            NotFoundReportException.class,
            NotFoundFileException.class,
            NotFoundEmployeeException.class,
            NotFoundCashRegisterException.class,
            NotFoundSalesException.class,
            NotFoundCategoriesException.class,
            NotFoundProductException.class,
            ProductsContainsDuplicateException.class,
            ProductsFollowingAreInactivesException.class,
            ProductsFollowingNotExistException.class
    })
    public ResponseEntity<ProblemDetail> handlerNotFoundException(Exception exception) {
        return this.buildResponse(HttpStatus.NOT_FOUND, exception);
    }

    //BAD REQUEST 400
    @ExceptionHandler({
            EmailAlreadyExistsException.class,
            ErrorFileTypeNotAllowedException.class,
            IllegalArgumentException.class,
            DataIntegrityViolationException.class
    })
    public ResponseEntity<ProblemDetail> handlerBadRequestException(Exception exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    //INTERNAL SERVER ERROR 500
    @ExceptionHandler({
            DataAccessException.class,
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
