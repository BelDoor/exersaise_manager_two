package com.exercise.service;

import com.exercise.domain.Users;
import com.exercise.repository.user_rep.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserAggregationServiceImpl implements UserAggregationService {
    @Autowired
    private UserRepository userRepository;

    private final UsersService usersService = new UsersServiceImpl();

    @Override
    public Map<String, Object> getStats() {
        List<Users> users = userRepository.findAll();
        Users one = userRepository.findOne(2L);

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("allUsers", users);
        resultMap.put("oneUser", one);

        return resultMap;
    }
}
