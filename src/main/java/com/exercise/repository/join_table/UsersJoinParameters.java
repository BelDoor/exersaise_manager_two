package com.exercise.repository.join_table;

import com.exercise.domain.UserParametrs;
import java.util.List;

public interface UsersJoinParameters {
    List<UserParametrs> findUserParameters(Long id);

}
