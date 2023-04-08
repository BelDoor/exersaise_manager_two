package com.exercise;

import com.exercise.repository.join_table.UsersJoinParameters;
import com.exercise.service.user_parameters.UserJoinParametersService;
import com.exercise.service.UsersService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.exercise");

        UserJoinParametersService usersJoinParameters = applicationContext.getBean("userJoinParametersServiceImpl", UserJoinParametersService.class);
        System.err.println(usersJoinParameters.findUserParameters(2L));

        UsersService usersService = applicationContext.getBean("usersServiceImpl", UsersService.class);
        System.err.println("\n--->\n");
        System.err.println(usersService.findOne(7L));
        System.err.println("\n--->\n");
        System.err.println(usersService.getRandomUsers());
        System.err.println("\n--->\n");
        System.out.println(usersService.findAll());
        System.out.println(usersService.findAll());
        System.err.println("\n--->\n");

        UsersJoinParameters usersJoinParameters2 = applicationContext.getBean("usersJoinParametersTemplateImpl",
                UsersJoinParameters.class);
        System.out.println(usersJoinParameters2.findUserParameters(3L));
    }
}
