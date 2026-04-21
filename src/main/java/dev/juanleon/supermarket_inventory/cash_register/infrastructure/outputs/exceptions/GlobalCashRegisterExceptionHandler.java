package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.exceptions;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NoCreateEmployeeOnDatabaseException;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalCashRegisterExceptionHandler {

    @ExceptionHandler(NotFoundEmployeeException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundEmployeeException(NotFoundEmployeeException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setTitle(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(NoCreateEmployeeOnDatabaseException.class)
    public ResponseEntity<ProblemDetail> handlerNoCreateEmployeeOnDatabaseException(NoCreateEmployeeOnDatabaseException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
