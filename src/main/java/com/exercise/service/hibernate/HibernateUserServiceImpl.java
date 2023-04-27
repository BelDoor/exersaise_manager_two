package com.exercise.service.hibernate;

import com.exercise.domain.hibernate_user.HibernateUser;
import com.exercise.domain.Users;
import com.exercise.repository.hibernate.HibernateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HibernateUserServiceImpl implements HibernateUserService{

    private final HibernateUserRepository hibernateUserRepository;

    @Override
    public HibernateUser findOne(Long id) {
        return hibernateUserRepository.findOne(id);
    }

    @Override
    public List<HibernateUser> findAll() {
        return hibernateUserRepository.findAll();
    }

    @Override
    public HibernateUser create(HibernateUser object) {
        return hibernateUserRepository.create(object);
    }

    @Override
    public HibernateUser update(Long id, HibernateUser object) {
        return hibernateUserRepository.update(id, object);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public HibernateUser getRandomUsers() {
        return null;
    }

    @Override
    public List<HibernateUser> searchUsers(String query, Integer height) {
        return null;
    }
}
