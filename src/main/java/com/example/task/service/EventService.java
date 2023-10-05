package com.example.task.service;

import com.example.task.dto.EventDto;
import com.example.task.entity.Event;
import com.example.task.persistence.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public void addEvent(EventDto eventDto) {
        Event event = convertToEvent(eventDto);

        Date currentDate = new Date();
        event.setDate(currentDate);

        eventRepository.save(event);
    }

    private Event convertToEvent(EventDto eventDTO) {
        return new Event(eventDTO.eventName(), eventDTO.userAuthorizationStatus(), eventDTO.ipAddress());
    }
}
