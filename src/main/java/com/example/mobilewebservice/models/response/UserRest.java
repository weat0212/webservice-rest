package com.example.mobilewebservice.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRest {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;

}
