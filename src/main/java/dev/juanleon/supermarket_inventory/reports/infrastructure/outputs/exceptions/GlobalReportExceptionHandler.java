package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.exceptions;

import dev.juanleon.supermarket_inventory.common.exception.BuildResponseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalReportExceptionHandler extends BuildResponseExceptions {

    @ExceptionHandler(NotFoundReportException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundReportException(NotFoundReportException exception) {
        return this.buildResponse(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(ErrorTryingCreateReport.class)
    public ResponseEntity<ProblemDetail> handlerErrorTryingCreateReport(ErrorTryingCreateReport exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }
}
