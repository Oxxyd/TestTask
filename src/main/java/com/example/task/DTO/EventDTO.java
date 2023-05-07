package com.example.task.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class EventDTO {
    @NotEmpty(message = "Event name should not be empty")
    private String eventName;

    private boolean userAuthorizationStatus;

    @NotEmpty(message = "Ip address should not be empty")
    private String ipAddress;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public boolean isUserAuthorizationStatus() {
        return userAuthorizationStatus;
    }

    public void setUserAuthorizationStatus(boolean userAuthorizationStatus) {
        this.userAuthorizationStatus = userAuthorizationStatus;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
