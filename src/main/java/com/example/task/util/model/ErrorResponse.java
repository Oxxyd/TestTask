package com.example.task.util.model;

import java.util.List;

public record ErrorResponse(
        String message,
        List<String> details,
        Integer status,
        Long timestamp
) {
}
