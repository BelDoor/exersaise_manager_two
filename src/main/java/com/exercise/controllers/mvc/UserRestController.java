package com.exercise.controllers.mvc;

import com.exercise.controllers.requests.UserCreateRequest;
import com.exercise.domain.Users;
import com.exercise.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        List<Users> allUsers = usersService.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UserCreateRequest createRequest){
        Users user = Users.builder()
                .name(createRequest.getName())
                .surname(createRequest.getSurname())
                .sex(createRequest.getSex())
                .height(createRequest.getHeight())
                .dateBirth(createRequest.getDateBirth())
                .roleId(createRequest.getRoleId())
                .build();

        Users createdUser = usersService.create(user);

        return new ResponseEntity<Users>(createdUser, HttpStatus.CREATED);
    }
}
