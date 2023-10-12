package com.example.task.util.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;
import java.util.List;

@Getter
public class EventNotAddedException extends RuntimeException {

    List<FieldError> errors;

    public EventNotAddedException(List<FieldError> errors) {
        this.errors = errors;
    }
}
