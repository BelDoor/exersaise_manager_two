package com.exersaise;

import com.exersaise.domain.Users;
import com.exersaise.repository.UserRepository;
import com.exersaise.repository.UserRepositoryImpl;
import com.exersaise.repository.contacts.ContactsRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.exersaise");

        ContactsRepository contactsRepository = applicationContext.getBean("contactsRepositoryImpl", ContactsRepository.class);

        System.out.println(contactsRepository.checkUserId(1L));
        System.out.println(contactsRepository.checkUserId(2L));
        System.out.println(contactsRepository.checkUserId(-2L));

        System.out.println(contactsRepository.checkId(1L));
        System.out.println(contactsRepository.checkId(2L));
        System.out.println(contactsRepository.checkId(-1L));

    }
}
