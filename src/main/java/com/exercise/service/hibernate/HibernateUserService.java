package com.exercise.service.hibernate;

import com.exercise.domain.HibernateUser.HibernateUser;
import com.exercise.domain.Users;

import java.util.List;

public interface HibernateUserService {
    HibernateUser findOne(Long id);

    List<HibernateUser> findAll();

    HibernateUser create(Users object);

    HibernateUser update(Long id, Users object);

    void delete(Long id);

    HibernateUser getRandomUsers();

    List<HibernateUser> searchUsers(String query, Integer height);
}
