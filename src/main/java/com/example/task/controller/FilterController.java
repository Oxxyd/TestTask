package com.example.task.controller;

import com.example.task.util.model.Filter;
import com.example.task.util.model.ResponseValue;
import com.example.task.service.FilterService;
import com.example.task.util.FilterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FilterController {

    private final FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }


    @PostMapping("/getFilteringResult")
    public ResponseValue getFilteringResult(@RequestBody Filter filter) throws FilterNotFoundException {
        return filterService.getResponseWithResult(filter);
    }
}
