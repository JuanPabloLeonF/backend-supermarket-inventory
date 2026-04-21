package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;

import dev.juanleon.supermarket_inventory.common.exception.BuildResponseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalUserExceptionHandler extends BuildResponseExceptions {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handlerEmailAlreadyExistsException(EmailAlreadyExistsException exception) {
        return this.buildResponse(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ProblemDetail> handlerNotFoundUserException(NotFoundUserException exception) {
        return this.buildResponse(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(NoCreateUserOnDatabaseException.class)
    public ResponseEntity<ProblemDetail> handlerNoCreateUserOnDatabaseException(NoCreateUserOnDatabaseException exception) {
        return this.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler(NoUpdateUserByIdException.class)
    public ResponseEntity<ProblemDetail> handlerNoUpdateUserByIdException(NoUpdateUserByIdException exception) {
        return this.buildResponse(HttpStatus.NOT_FOUND, exception);
    }
}
