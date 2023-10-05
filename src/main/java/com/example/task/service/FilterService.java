package com.example.task.service;

import com.example.task.util.model.Filter;
import com.example.task.util.model.ResponseValue;
import com.example.task.persistence.EventRepository;
import com.example.task.util.FilterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterService {

    private static final String FILTER_DOES_NOT_EXIST = "Such a filter does not exist. Please repeat your request";

    private final EventRepository eventRepository;

    @Autowired
    public FilterService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public ResponseValue getResponseWithResult(Filter filter) throws FilterNotFoundException {
        String additionalParameter = filter.additionalParameter();
        ResponseValue response = new ResponseValue();

        switch (filter.filterName()) {
            case "by_event_name" -> response.setResponseValue(getQuantityEventsByName(additionalParameter));
            case "by_ip_address" -> response.setResponseValue(getQuantityEventsByIpAddress(additionalParameter));
            case "by_user_authorization_status" ->
                    response.setResponseValue(getQuantityEventsAuthorizationStatus(additionalParameter));
            default -> throw new FilterNotFoundException(FILTER_DOES_NOT_EXIST);
        }

        return response;
    }

    private long getQuantityEventsByName(String additionalParameter) {
        return eventRepository.countByEventNameEquals(additionalParameter);
    }

    private long getQuantityEventsByIpAddress(String additionalParameter) {
        return eventRepository.countByIpAddressEquals(additionalParameter);
    }

    private long getQuantityEventsAuthorizationStatus(String additionalParameter) {
        if (additionalParameter.equals("true")) {
            return eventRepository.countByUserAuthorizationStatusTrue();
        } else {
            return eventRepository.countByUserAuthorizationStatusFalse();
        }
    }
}
