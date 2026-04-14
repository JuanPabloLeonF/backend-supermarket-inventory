package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalReportExceptionHandler {

    private ResponseEntity<ProblemDetail> buildResponse(HttpStatus status, Exception exception) {
        ProblemDetail response = ProblemDetail.forStatus(status);
        response.setTitle(status.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(NotFoundReportException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundReportException(NotFoundReportException exception) {
        return this.buildResponse(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(ErrorTryingCreateReport.class)
    public ResponseEntity<ProblemDetail> handlerErrorTryingCreateReport(ErrorTryingCreateReport exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}
