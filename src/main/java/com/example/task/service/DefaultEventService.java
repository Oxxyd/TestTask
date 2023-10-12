package com.example.task.service;

import com.example.task.dto.EventDto;
import com.example.task.entity.Event;
import com.example.task.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DefaultEventService implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    @Transactional
    public void addEvent(EventDto eventDto) {
        Event event = eventMapper.toBusinessModel(eventDto);

        Date currentDate = new Date();
        event.setDate(currentDate);

        eventRepository.save(event);
    }
}
