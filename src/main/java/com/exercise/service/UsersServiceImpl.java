package com.exercise.service;

import com.exercise.domain.Users;
import com.exercise.repository.user_rep.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findOne(Long id) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users create(Users object) {
        if (object.getHeight() > 175) {
            throw new RuntimeException("Something wrong!");
        }

        return userRepository.create(object);
    }

    @Override
    public Users update(Users object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
