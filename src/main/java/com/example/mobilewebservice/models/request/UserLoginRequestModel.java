package com.example.mobilewebservice.models.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequestModel {

    private String email;
    private String password;
}
