package com.exercise.service.hibernate;

import com.exercise.domain.hibernate_user.HibernateUser;
import com.exercise.domain.Users;

import java.util.List;

public interface HibernateUserService {
    HibernateUser findOne(Long id);

    List<HibernateUser> findAll();

    HibernateUser create(HibernateUser object);

    HibernateUser update(Long id, HibernateUser object);

    void delete(Long id);

    HibernateUser getRandomUsers();

    List<HibernateUser> searchUsers(String query, Integer height);
}
