package com.cleanbank.core.createuser;

import com.cleanbank.entities.UserEntity;

public interface UserRepository {
    UserEntity findUserById(long id);
}
