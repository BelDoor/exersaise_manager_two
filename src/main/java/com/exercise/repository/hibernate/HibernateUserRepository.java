package com.exercise.repository.hibernate;

import com.exercise.domain.hibernate_user.HibernateUser;
import com.exercise.repository.CRUDRepository;

import java.util.List;

public interface HibernateUserRepository extends CRUDRepository<Long, HibernateUser> {

    List<HibernateUser> searchUser(String query, Double weight);

}
