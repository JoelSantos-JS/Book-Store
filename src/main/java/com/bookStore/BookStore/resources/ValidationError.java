package com.bookStore.BookStore.resources;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandError {

    public List<FieldMessage> getErrors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String message) {
        super(timestamp, status, message);
    }

    public List<FieldMessage> getGetErrors() {
        return getErrors;
    }

    public void AddGetErrors(String fieldName, String message) {
        this.getErrors.add(new FieldMessage(fieldName, message));
    }

}
