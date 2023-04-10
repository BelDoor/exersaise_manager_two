package com.exercise.service.UserParameters;

import com.exercise.domain.UserParametrs;
import com.exercise.repository.join_table.UsersJoinParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJoinParametersServiceImpl implements UserJoinParametersService {
    @Autowired
    UsersJoinParameters usersJoinParameters;

    @Override
    public List<UserParametrs> findUserParameters(Long id) {
        if (id >= 0) {
            if (id == 2 || id == 3) {
                return usersJoinParameters.findUserParameters(id);
            } else {
                System.err.println("ID out of bounds");
                return usersJoinParameters.findUserParameters(id);
            }
        } else {
            return null;
        }
    }
}