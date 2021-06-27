package com.example.mobilewebservice.models.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
