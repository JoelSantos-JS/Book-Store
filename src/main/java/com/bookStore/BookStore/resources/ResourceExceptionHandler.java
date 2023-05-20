package com.bookStore.BookStore.resources;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.ServerRequest;

import com.bookStore.BookStore.services.exceptions.DateIntegrityViolention;
import com.bookStore.BookStore.services.exceptions.ObjectNotFound;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandError> handleObjectNotFoundException(ObjectNotFound e, ServerRequest request) {
        StandError error = new StandError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandError> handleDateIntegritySException(DateIntegrityViolention e, ServerRequest request) {
        StandError error = new StandError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
            ServerRequest request) {
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Erro de validação");

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.AddGetErrors(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
