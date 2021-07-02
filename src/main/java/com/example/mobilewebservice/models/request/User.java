package com.example.mobilewebservice.models.request;

import lombok.*;

@Data
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
