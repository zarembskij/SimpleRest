package com.zarembski.nn.api.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zarembski.nn.api.JsonResponse;
import com.zarembski.nn.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class UserMapper {

    @Autowired
    private ObjectMapper mapper;

    @PostConstruct
    public void setUp() {
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        mapper.writerWithDefaultPrettyPrinter();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public String generateOutputData(User user) {
        try {
            return mapper.writerWithView(User.class).writeValueAsString(user);
        } catch (JsonProcessingException e) {
            log.error(String.format("Json processing error for login %s", user.getLogin()));
            return JsonResponse.ERROR.getValue();
        }
    }
}
