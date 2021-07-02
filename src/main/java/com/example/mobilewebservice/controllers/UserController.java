package com.example.mobilewebservice.controllers;

import com.example.mobilewebservice.api.UserDto;
import com.example.mobilewebservice.models.request.User;
import com.example.mobilewebservice.models.response.UserRest;
import com.example.mobilewebservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser() {
        return "Get User";
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public UserRest createUser(@RequestBody User userDetails) throws Exception {

        ModelMapper modelMapper = new ModelMapper();

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdUser = userService.createUser(userDto);

        UserRest returnValue = modelMapper.map(createdUser, UserRest.class);

        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "Update User";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User";
    }
}
