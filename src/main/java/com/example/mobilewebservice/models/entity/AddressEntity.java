package com.example.mobilewebservice.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "addresses")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = -7973257537252403477L;

    @Id
    @GeneratedValue
    private Long id;

    private String address;

//    @ManyToOne
//    private UserEntity userEntity;

}
