package com.exersaise;

import com.exersaise.domain.Users;
import com.exersaise.repository.UserRepository;
import com.exersaise.repository.UserRepositoryImpl;

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
