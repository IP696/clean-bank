package com.cleanbank.core;

import com.cleanbank.core.createuser.*;
import com.cleanbank.entities.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = new UserRepositoryStub();
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void createUser() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setId(1L);

        CreateUserResponse userResponse = userService.createUser(userRequest);

        assertEquals("userName", userResponse.getUserName());
    }

    private class UserRepositoryStub implements UserRepository {
        @Override
        public UserEntity findUserById(long id) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("userName");
            return userEntity;
        }
    }
}
