package com.zarembski.nn.service;


import com.zarembski.nn.api.ApiRequestFactory;
import com.zarembski.nn.api.JsonResponse;
import com.zarembski.nn.api.mapper.UserMapper;
import com.zarembski.nn.domain.RequestCounter;
import com.zarembski.nn.domain.User;
import com.zarembski.nn.repository.RequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@Service
@Slf4j
public class UserService {

    @Autowired
    ApiRequestFactory apiRequestFactory;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserMapper userMapper;

    public String getUserData(String login) {
        Response response = apiRequestFactory.invoke(login);
        return response.getStatus() == Response.Status.OK.getStatusCode() ?
                processOkResponse(response) : JsonResponse.NOT_FOUND.getValue();
    }

    private String processOkResponse(Response response) {
        User user = response.readEntity(new GenericType<User>() {});
        RequestCounter requests = requestRepository.findByLogin(user.getLogin()).stream().findFirst().orElse(buildNewCounter(user.getLogin()));
        requestRepository.save(increment(requests));
        log.info(String.format("Save request for login %s and request count %s", requests.getLogin(), requests.getRequestCount()));
        return userMapper.generateOutputData(user);
    }

    private RequestCounter buildNewCounter(String login) {
        return RequestCounter.builder().login(login).build();
    }

    private RequestCounter increment(RequestCounter request) {
        request.setRequestCount(request.getRequestCount() != null ? request.getRequestCount() + 1 : 1);
        return request;
    }
}
