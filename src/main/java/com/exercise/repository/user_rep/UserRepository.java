package com.exercise.repository.user_rep;

import com.exercise.domain.Users;
import com.exercise.repository.CRUDRepository;

import java.util.List;

public interface UserRepository extends CRUDRepository<Long, Users> {
    Users getRandomUsers();

    List<Users> searchUsers(String query, Integer height);

}
