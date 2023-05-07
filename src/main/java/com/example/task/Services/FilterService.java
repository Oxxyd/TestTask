package com.example.task.Services;

import com.example.task.Model.Filter;
import com.example.task.Model.Response;
import com.example.task.Repositories.EventRepository;
import com.example.task.util.FilterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterService {

    private final EventRepository eventRepository;

    @Autowired
    public FilterService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Response getResponseWithResult(Filter filter) throws FilterNotFoundException {
        String additionalParameter = filter.getAdditionalParameter();
        Response response = new Response();

        switch (filter.getFilterName()){
            case "by_event_name":
                response.setResponseValue(getQuantityEventsByName(additionalParameter));
                break;
            case "by_ip_address":
                response.setResponseValue(getQuantityEventsByIpAddress(additionalParameter));
                break;
            case "by_user_authorization_status":
                response.setResponseValue(getQuantityEventsAuthorizationStatus(additionalParameter));
                break;
            default:
                throw new FilterNotFoundException();
        }

        return response;
    }

    private long getQuantityEventsByName(String additionalParameter){
        return eventRepository.countByEventNameEquals(additionalParameter);
    }

    private long getQuantityEventsByIpAddress(String additionalParameter){
        return eventRepository.countByIpAddressEquals(additionalParameter);
    }

    private long getQuantityEventsAuthorizationStatus(String additionalParameter){
        if(additionalParameter.equals("true")){
            return eventRepository.countByUserAuthorizationStatusTrue();
        }else{
            return eventRepository.countByUserAuthorizationStatusFalse();
        }
    }
}
