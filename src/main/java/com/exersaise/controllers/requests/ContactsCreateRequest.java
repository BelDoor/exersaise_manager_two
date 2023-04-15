package com.exersaise.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ContactsCreateRequest {

    private Long id;
    private Long userId;
    private Long phoneNumber;
    private String email;
    private String city;
    private String country;
    private String street;
    private Integer houseNumber;
    private Integer flat;
    private Timestamp created;
    private Timestamp changed;
    private Boolean deleted;
}
