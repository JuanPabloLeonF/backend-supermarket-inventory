package dev.juanleon.supermarket_inventory.files.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalFileExceptionHandler {

    private ResponseEntity<ProblemDetail> buildResponse(HttpStatus status, Exception exception) {
        ProblemDetail response = ProblemDetail.forStatus(status);
        response.setTitle(status.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(NotFoundFileException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoudFileException(NotFoundFileException exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(ErrorTryingSaveFileException.class)
    public ResponseEntity<ProblemDetail> handlerErrorTryingSaveFileException(ErrorTryingSaveFileException exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler(ErrorTryingDeleteFileException.class)
    public ResponseEntity<ProblemDetail> handlerErrorTryingDeleteFileException(ErrorTryingDeleteFileException exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler(ErrorFileTypeNotAllowedException.class)
    public ResponseEntity<ProblemDetail> handlerErrorFileTypeNotAllowedException(ErrorFileTypeNotAllowedException exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(ErrorCreatedDirectoriesException.class)
    public ResponseEntity<ProblemDetail> handlerErrorCreatedDirectoriesException(ErrorCreatedDirectoriesException exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler(ErrorConvertingImageToWebpException.class)
    public ResponseEntity<ProblemDetail> handlerErrorConvertingImageToWebpException(ErrorConvertingImageToWebpException exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}
