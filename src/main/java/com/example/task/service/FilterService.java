package com.example.task.service;

import com.example.task.util.model.Filter;
import com.example.task.util.model.ResponseValue;

public interface FilterService {
    ResponseValue getResponseWithResult(Filter filter);
}
