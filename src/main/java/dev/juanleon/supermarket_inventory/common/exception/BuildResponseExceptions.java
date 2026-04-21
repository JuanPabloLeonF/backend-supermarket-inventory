package dev.juanleon.supermarket_inventory.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;

public class BuildResponseExceptions {

    protected ResponseEntity<ProblemDetail> buildResponse(HttpStatus status, Exception exception) {
        ProblemDetail response = ProblemDetail.forStatus(status);
        response.setTitle(status.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity.status(status).body(response);
    }

    protected ResponseEntity<ProblemDetail> buildResponse(HttpStatus status, Exception exception, Map<String, String> erros) {
        ProblemDetail response = ProblemDetail.forStatus(status);
        response.setTitle(status.getReasonPhrase());
        response.setDetail(exception.getMessage());
        response.setProperty("erros", erros);
        response.setProperty("date", LocalDateTime.now());
        response.setProperty("typeError", exception.getClass().getSimpleName());
        return ResponseEntity.status(status).body(response);
    }
}
