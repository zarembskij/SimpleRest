package com.zarembski.nn.controller;

import com.zarembski.nn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/{login}")
    public String getUserData(@PathVariable(value="login") String login) {
        return userService.getUserData(login);
    }
}
