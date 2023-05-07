package com.example.task.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "Events")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "event_name")
    @NotEmpty(message = "Event name should not be empty")
    private String eventName;

    @Column(name = "user_authorization_status")
    private boolean userAuthorizationStatus;

    @Column(name = "ip_address")
    @NotEmpty(message = "Ip address should not be empty")
    private String ipAddress;

    @Column(name = "date")
    private Date date;

    public Event(String eventName, boolean userStatus, Date date, String ipAddress) {
        this.eventName = eventName;
        this.userAuthorizationStatus = userStatus;
        this.ipAddress = ipAddress;
        this.date = date;
    }

    public Event(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public boolean getUserAuthorizationStatus() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
