package com.example.task.dto;

import jakarta.validation.constraints.NotBlank;

public record EventDto(
        @NotBlank(message = "Event name should not be empty")
        String eventName,
        Boolean userAuthorizationStatus,
        @NotBlank(message = "Ip address should not be empty")
        String ipAddress
) {
}
