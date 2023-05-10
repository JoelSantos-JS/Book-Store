package com.bookStore.BookStore.Service.exceptions;

public class DateIntegrityViolention extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DateIntegrityViolention(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public DateIntegrityViolention(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
