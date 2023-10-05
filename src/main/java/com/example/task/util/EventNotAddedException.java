package com.example.task.util;

import org.springframework.validation.FieldError;

import java.util.List;

public class EventNotAddedException extends Exception {

    List<FieldError> errors;

    public EventNotAddedException(List<FieldError> errors) {
        this.errors = errors;
    }

    public List<FieldError> getErrors() {
        return errors;
    }
}
