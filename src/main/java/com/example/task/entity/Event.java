package com.example.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Events")
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "event_name")
    @NotBlank(message = "Event name should not be empty")
    private String eventName;

    @Column(name = "user_authorization_status")
    private boolean userAuthorizationStatus;

    @Column(name = "ip_address")
    @NotBlank(message = "Ip address should not be empty")
    private String ipAddress;

    @Column(name = "date")
    private Date date;

    public Event(String eventName, boolean userAuthorizationStatus, String ipAddress) {
        this.eventName = eventName;
        this.userAuthorizationStatus = userAuthorizationStatus;
        this.ipAddress = ipAddress;
    }
}
