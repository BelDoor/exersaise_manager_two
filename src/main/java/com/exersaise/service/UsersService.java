package com.exersaise.service;

import com.exersaise.domain.Users;

import java.util.List;

public interface UsersService {

    Users findOne(Long id);

    List<Users> findAll();

    Users create(Users object);

    Users update(Users object);

    void delete(Long id);
}
