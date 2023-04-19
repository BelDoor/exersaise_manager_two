package com.exercise.controllers.rest;

import com.exercise.domain.HibernateUser.HibernateUser;
import com.exercise.service.hibernate.HibernateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/hibernate/user")
@RequiredArgsConstructor
public class HibernateUserController {

    private final HibernateUserService hibernateUserService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<HibernateUser> users = hibernateUserService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
