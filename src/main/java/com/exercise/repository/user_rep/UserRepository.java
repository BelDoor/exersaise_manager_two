package com.exercise.repository.user_rep;

import com.exercise.domain.Users;
import com.exercise.repository.CRUDRepository;

public interface UserRepository extends CRUDRepository<Long, Users> {
    Users getRandomUsers();
}
