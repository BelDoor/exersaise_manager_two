package com.exercise;

import com.exercise.domain.Users;
import com.exercise.repository.user_rep.UserRepository;
import com.exercise.repository.user_rep.UserRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryImpl();

        List<Users> all = userRepository.findAll();

        for (Users user : all) {
            System.out.println(user);
        }

    }
}
