package com.exercise.springTest;

import com.exercise.repository.user_rep.UserRepository;
import com.exercise.service.UsersService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext acac =
                new AnnotationConfigApplicationContext("com.exersaise");

        UserRepository userRepository = acac.getBean("userRepositoryImpl", UserRepository.class);
        UsersService usersService = acac.getBean("usersServiceImpl", UsersService.class);

        System.out.println(userRepository.findAll());
        System.out.println(usersService.findAll());

    }
}
