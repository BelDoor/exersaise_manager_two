package com.exersaise.repository;

import com.exersaise.domain.Users;

public interface UserRepository extends CRUDRepository<Long, Users>{
    void serchUser();
}
