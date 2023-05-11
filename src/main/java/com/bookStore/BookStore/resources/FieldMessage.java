package com.bookStore.BookStore.resources;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    public String fieldName;
    private String message;

    public FieldMessage() {

    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
