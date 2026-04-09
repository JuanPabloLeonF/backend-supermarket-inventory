package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalUserExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handlerEmailAlreadyExistsException(EmailAlreadyExistsException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        response.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundUserException(NotFoundUserException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setTitle(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(NoCreateUserOnDatabaseException.class)
    public ResponseEntity<ProblemDetail> handlerNoCreateUserOnDatabaseException(NoCreateUserOnDatabaseException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(NoUpdateUserByIdException.class)
    public ResponseEntity<ProblemDetail> handlerNoUpdateUserByIdException(NoUpdateUserByIdException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle(HttpStatus.NOT_FOUND.getReasonPhrase());
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setProperty("date", LocalDateTime.now());
        problemDetail.setProperty("typeError", NoUpdateUserByIdException.class.getSimpleName());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(problemDetail);
    }
}
