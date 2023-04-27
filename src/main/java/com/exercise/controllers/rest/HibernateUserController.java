package com.exercise.controllers.rest;

import com.exercise.controllers.requests.UserCreateRequest;
import com.exercise.controllers.requests.UserUpdateRequest;
import com.exercise.domain.Sex;
import com.exercise.domain.hibernate_user.HibernateUser;
import com.exercise.service.hibernate.HibernateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
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

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody UserCreateRequest userCreateRequest) {

        HibernateUser user = HibernateUser.builder()
                .name(userCreateRequest.getName())
                .surname(userCreateRequest.getSurname())
                .dateBirth(userCreateRequest.getDateBirth())
                .sex(Sex.NOT_SELECTED)
                .height(userCreateRequest.getHeight())
                .roleId(userCreateRequest.getRoleId())
                .build();

        user = hibernateUserService.create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody UserUpdateRequest request/*, Principal principal*/) {

        HibernateUser user = hibernateUserService.findOne(request.getId());

        user.setId(request.getId());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setDateBirth(request.getDateBirth());
        user.setSex(Sex.valueOf(request.getSex()));
        user.setHeight(request.getHeight());
        user.setRoleId(request.getRoleId());

        user = hibernateUserService.update(request.getId(), user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}