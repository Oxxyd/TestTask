package com.example.task.controller;

import com.example.task.dto.EventDto;;
import com.example.task.service.DefaultEventService;
import com.example.task.util.exception.EventNotAddedException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final DefaultEventService defaultEventService;

    @PostMapping("/addNewEventRecord")
    public ResponseEntity<HttpStatus> addNewEventRecord(@RequestBody @Valid EventDto eventDto,
                                                        BindingResult bindingResult) throws EventNotAddedException {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();

            throw new EventNotAddedException(errors);
        }
        defaultEventService.addEvent(eventDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
