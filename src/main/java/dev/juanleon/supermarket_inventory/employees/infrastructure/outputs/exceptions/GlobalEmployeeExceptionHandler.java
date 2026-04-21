package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions;

import dev.juanleon.supermarket_inventory.common.exception.BuildResponseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalEmployeeExceptionHandler extends BuildResponseExceptions {

    @ExceptionHandler(NotFoundEmployeeException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundEmployeeException(NotFoundEmployeeException exception) {
        return this.buildResponse(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(NoCreateEmployeeOnDatabaseException.class)
    public ResponseEntity<ProblemDetail> handlerNoCreateEmployeeOnDatabaseException(NoCreateEmployeeOnDatabaseException exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}
