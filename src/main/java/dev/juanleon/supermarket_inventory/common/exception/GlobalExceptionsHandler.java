package dev.juanleon.supermarket_inventory.common.exception;

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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> handlerIllegalArgumentException(IllegalArgumentException exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(NotFoundTypeRequestHandlerMediator.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundTypeRequestHandlerMediator(NotFoundTypeRequestHandlerMediator exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, String> erros = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });

        return this.buildResponse(HttpStatus.BAD_REQUEST, exception, erros);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ProblemDetail> handlerDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetail> handlerHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }


}
