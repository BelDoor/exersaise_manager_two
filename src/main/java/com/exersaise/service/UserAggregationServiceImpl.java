package com.exersaise.service;

import com.exersaise.domain.Users;
import com.exersaise.repository.UserRepository;
import com.exersaise.repository.UserRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAggregationServiceImpl implements UserAggregationService{

    private final UserRepository userRepository = new UserRepositoryImpl();
    private final UsersService usersService = new UsersServiceImpl();

    @Override
    public Map<String, Object> getStats() {
        List<Users> users = userRepository.findAll();
        Users one = userRepository.findOne(2L);
        userRepository.serchUser();

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("allUsers", users);
        resultMap.put("oneUser", one);

        return resultMap;
    }
}
