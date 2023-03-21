package com.exercise.repository.join_table;

import com.exercise.domain.UserParametrs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersJoinParametersSecondImpl implements UsersJoinParameters {
    @Override
    public List<UserParametrs> findUserParameters(Long id) {
        return null;
    }
}
