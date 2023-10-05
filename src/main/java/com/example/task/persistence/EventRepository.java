package com.example.task.persistence;

import com.example.task.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
    long countByUserAuthorizationStatusTrue();

    long countByUserAuthorizationStatusFalse();

    long countByIpAddressEquals(String ipAddress);

    long countByEventNameEquals(String eventName);
}
