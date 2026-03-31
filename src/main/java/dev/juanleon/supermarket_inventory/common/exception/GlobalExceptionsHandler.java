package dev.juanleon.supermarket_inventory.common.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> handlerIllegalArgumentException(IllegalArgumentException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        response.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(NotFoundTypeRequestHandlerMediator.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundTypeRequestHandlerMediator(NotFoundTypeRequestHandlerMediator exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        response.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());

        Map<String, String> erros = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });

        response.setDetail(erros.toString());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ProblemDetail> handlerDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        response.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetail> handlerHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        ProblemDetail response = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        response.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }


}
