package com.example.mobilewebservice.controllers;

import com.example.mobilewebservice.api.UserDto;
import com.example.mobilewebservice.models.request.User;
import com.example.mobilewebservice.models.response.UserRest;
import com.example.mobilewebservice.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @GetMapping
    public String getUser() {
        return "";
    }

    @PostMapping
    public UserRest createUser(@RequestBody User userDetails) {

        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        // copy userDetails to userDto
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "";
    }

    @DeleteMapping
    public String deleteUser() {
        return "";
    }
}
