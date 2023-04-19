package com.exercise.service.hibernate;

import com.exercise.domain.HibernateUser.HibernateUser;
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
        return null;
    }

    @Override
    public List<HibernateUser> findAll() {
        return hibernateUserRepository.findAll();
    }

    @Override
    public HibernateUser create(Users object) {
        return null;
    }

    @Override
    public HibernateUser update(Long id, Users object) {
        return null;
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
