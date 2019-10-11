package com.zarembski.nn.service;

import com.zarembski.nn.api.ApiRequestFactory;
import com.zarembski.nn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.GenericType;

@Service
public class UserService {

    @Autowired
    ApiRequestFactory apiRequestFactory;

    public String getUserData(String login) {
        return apiRequestFactory.invoke(login).readEntity(new GenericType<User>() {}).toString();
    }
}
