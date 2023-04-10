package com.exercise.service;

import com.exercise.domain.Users;
import com.exercise.repository.user_rep.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users create(Users object) {
        return userRepository.create(object);
    }

    @Override
    public Users update(Long id, Users object) {
        return userRepository.update(id, object);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public Users getRandomUsers() {
        return userRepository.getRandomUsers();
    }
}
