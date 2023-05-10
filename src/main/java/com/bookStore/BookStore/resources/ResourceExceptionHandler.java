package com.bookStore.BookStore.resources;

import org.apache.catalina.connector.Response;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.ServerRequest;

import com.bookStore.BookStore.Service.exceptions.ObjectNotFound;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandError> handleObjectNotFoundException(ObjectNotFound e, ServerRequest request) {
        StandError error = new StandError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
