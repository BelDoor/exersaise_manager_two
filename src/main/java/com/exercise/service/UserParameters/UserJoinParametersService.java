package com.exercise.service.UserParameters;

import com.exercise.domain.UserParametrs;

import java.util.List;

public interface UserJoinParametersService {
    List<UserParametrs> findUserParameters(Long id);
}
