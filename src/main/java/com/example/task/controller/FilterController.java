package com.example.task.controller;

import com.example.task.util.model.Filter;
import com.example.task.util.model.ResponseValue;
import com.example.task.service.DefaultFilterService;
import com.example.task.util.exception.FilterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
@RequiredArgsConstructor
public class FilterController {

    private final DefaultFilterService defaultFilterService;

    @PostMapping("/getFilteringResult")
    public ResponseValue getFilteringResult(@RequestBody Filter filter) throws FilterNotFoundException {
        return defaultFilterService.getResponseWithResult(filter);
    }
}
