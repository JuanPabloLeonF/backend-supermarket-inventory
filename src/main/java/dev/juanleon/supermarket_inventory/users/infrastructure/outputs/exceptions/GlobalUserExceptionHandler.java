package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalUserExceptionHandler {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundUserException(NotFoundUserException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setTitle(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getName());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
