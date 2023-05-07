package com.example.task.Controllers;

import com.example.task.DTO.EventDTO;
import com.example.task.Model.Event;
import com.example.task.Services.EventService;
import com.example.task.util.ErrorResponse;
import com.example.task.util.EventNotAddedException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;
    private final ModelMapper modelMapper;

    @Autowired
    public EventController(EventService eventService, ModelMapper modelMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/addNewEventRecord")
    public ResponseEntity<HttpStatus> addNewEventRecord(@RequestBody @Valid EventDTO eventDTO,
                                                        BindingResult bindingResult) throws EventNotAddedException {
        if (bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error: errors){
                errorMessage.append(error.getField()).append("; ").
                        append(error.getDefaultMessage()).append(".");
            }
            throw new EventNotAddedException(errorMessage.toString());
        }

        eventService.addEvent(convertToEvent(eventDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Event convertToEvent(EventDTO eventDTO){
        return modelMapper.map(eventDTO, Event.class);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(EventNotAddedException e){
        ErrorResponse response = new ErrorResponse(
                e.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
