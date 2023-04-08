package com.exercise.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private String name;
    private String surname;
    private Timestamp dateBirth;
    private String sex;
    private Integer height;
    private Long roleId;
}
