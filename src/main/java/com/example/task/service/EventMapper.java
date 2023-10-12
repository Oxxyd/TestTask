package com.example.task.service;

import com.example.task.dto.EventDto;
import com.example.task.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    Event toBusinessModel(EventDto eventDto);
}
