package com.example.mobilewebservice.services;

import com.example.mobilewebservice.api.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
}
