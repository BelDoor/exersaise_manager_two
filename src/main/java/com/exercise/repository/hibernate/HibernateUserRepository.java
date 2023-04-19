package com.exercise.repository.hibernate;

import com.exercise.domain.HibernateUser.HibernateUser;
import com.exercise.repository.CRUDRepository;

import java.util.List;

public interface HibernateUserRepository extends CRUDRepository<Long, HibernateUser> {

    List<HibernateUser> searchUser(String query, Double weight);

}
