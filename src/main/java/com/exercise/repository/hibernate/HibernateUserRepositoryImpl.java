package com.exercise.repository.hibernate;

import com.exercise.domain.HibernateUser.HibernateUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HibernateUserRepositoryImpl implements HibernateUserRepository{

    private final SessionFactory sessionFactory;

    @Override
    public HibernateUser findOne(Long id) {
        return null;
    }

    @Override
    public List<HibernateUser> findAll() {
        final String findAllHQL = "select u from HibernateUser u";
        //final String findAllNative = "select * from users";

        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(findAllHQL, HibernateUser.class).getResultList();
        }
    }

    @Override
    public HibernateUser create(HibernateUser object) {
        return null;
    }

    @Override
    public HibernateUser update(Long id, HibernateUser object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<HibernateUser> searchUser(String query, Double weight) {
        return null;
    }
}
