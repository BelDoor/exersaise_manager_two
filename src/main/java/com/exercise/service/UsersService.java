package com.exercise.service;

import com.exercise.domain.Users;
import java.util.List;

public interface UsersService {

    Users findOne(Long id);

    List<Users> findAll();

    Users create(Users object);

    Users update(Long id, Users object);

    void delete(Long id);

    Users getRandomUsers();

    List<Users> searchUsers(String query, Integer height);
}
