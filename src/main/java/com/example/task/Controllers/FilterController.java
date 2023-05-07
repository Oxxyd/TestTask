package com.example.task.Controllers;

import com.example.task.Model.Filter;
import com.example.task.Model.Response;
import com.example.task.Services.FilterService;
import com.example.task.util.ErrorResponse;
import com.example.task.util.EventNotAddedException;
import com.example.task.util.FilterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filter")
public class FilterController {

    private final FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }


    @PostMapping("/getFilteringResult")
    public Response getFilteringResult(@RequestBody Filter filter) throws FilterNotFoundException {
        Response response = filterService.getResponseWithResult(filter);

        return response;
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(FilterNotFoundException e){
        ErrorResponse response = new ErrorResponse(
                "Such a filter does not exist. Please repeat your request.",
                System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
