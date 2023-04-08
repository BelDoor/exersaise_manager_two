package com.exercise.service;

import com.exercise.domain.Users;
import com.exercise.repository.user_rep.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Override
    public List<Users> searchUsers(String query, Integer height) {
        return userRepository.searchUsers(query, height);
    }

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
