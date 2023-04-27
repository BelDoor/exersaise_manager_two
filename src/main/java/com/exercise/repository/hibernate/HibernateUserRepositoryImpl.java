package com.exercise.repository.hibernate;

import com.exercise.domain.hibernate_user.HibernateUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HibernateUserRepositoryImpl implements HibernateUserRepository {

    private final SessionFactory sessionFactory;

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public HibernateUser findOne(Long id) {
        final String findByIdHQL = "select u from HibernateUser u where u.id = " + id;

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery(findByIdHQL, HibernateUser.class).getSingleResult();
    }

    @Override
    public List<HibernateUser> findAll() {
        final String findAllHQL = "select u from HibernateUser u";


//        try (Session session = sessionFactory.openSession()) {
//            return session.createQuery(findAllHQL, HibernateUser.class).getResultList();
//        }

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery(findAllHQL, HibernateUser.class).getResultList();
    }

    @Override
    public HibernateUser create(HibernateUser object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            session.saveOrUpdate(object);
            session.flush();

            transaction.commit();

            return object;
        }
    }

    @Override
    public HibernateUser update(Long id, HibernateUser object) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            session.saveOrUpdate(object);
            session.flush();

            transaction.commit();

            return object;
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<HibernateUser> searchUser(String query, Double weight) {
        return null;
    }
}
