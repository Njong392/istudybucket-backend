package com.feljtech.istudybucket.controller;

import com.feljtech.istudybucket.form.RegisterForm;
import com.feljtech.istudybucket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kanye
 * Controller for the User entity: Handles all requests under the "/user/" endpoint
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;

    /**
     * Autowired userService bean by Constructor DI into userController
     * @param userService: the userService bean to be injected
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * registers a user from a RegisterForm object, consumed from JSON.
     * typically, control is passed to the userService bean.
     * @param registerForm: the form as an object - spring auto converts based on input names.
     * @return the id of the user on a successful registration
     */
    @PostMapping(value = "register")
    public Long register(@RequestBody RegisterForm registerForm) {
        return userService.registerUser(registerForm);
    }
}
