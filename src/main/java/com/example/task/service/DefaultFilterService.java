package com.example.task.service;

import com.example.task.util.model.Filter;
import com.example.task.util.model.ResponseValue;
import com.example.task.persistence.EventRepository;
import com.example.task.util.exception.FilterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DefaultFilterService implements FilterService {

    private static final String FILTER_DOES_NOT_EXIST = "Such a filter does not exist. Please repeat your request";

    private final String eventFilterLabel;

    private final String ipAddressFilterLabel;

    private final String userAuthStatusFilterLabel;

    private final EventRepository eventRepository;

    @Autowired
    public DefaultFilterService(@Value("${filter-label.by-event-name}") String eventFilterLabel,
                                @Value("${filter-label.by-ip-address}") String ipAddressFilterLabel,
                                @Value("${filter-label.by-user-auth-status}") String userAuthStatusFilterLabel,
                                EventRepository eventRepository) {
        this.eventFilterLabel = eventFilterLabel;
        this.ipAddressFilterLabel = ipAddressFilterLabel;
        this.userAuthStatusFilterLabel = userAuthStatusFilterLabel;
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseValue getResponseWithResult(Filter filter) throws FilterNotFoundException {
        String additionalParameter = filter.additionalParameter();

        ResponseValue response = new ResponseValue();

        if (eventFilterLabel.equals(filter.filterName())) {
            response.setResponseValue(getQuantityEventsByName(additionalParameter));
        } else if (ipAddressFilterLabel.equals(filter.filterName())) {
            response.setResponseValue(getQuantityEventsByIpAddress(additionalParameter));
        } else if (userAuthStatusFilterLabel.equals(filter.filterName())) {
            response.setResponseValue(getQuantityEventsAuthorizationStatus(additionalParameter));
        } else {
            throw new FilterNotFoundException(FILTER_DOES_NOT_EXIST);
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
