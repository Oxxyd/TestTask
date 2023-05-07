package com.example.task.Services;

import com.example.task.Model.Event;
import com.example.task.Repositories.EventRepository;
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
    public void addEvent(Event event){
        Date currentDate = new Date();
        event.setDate(currentDate);

        eventRepository.save(event);
    }
}
