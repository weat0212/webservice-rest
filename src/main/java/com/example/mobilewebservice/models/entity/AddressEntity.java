package com.example.mobilewebservice.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String address;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
