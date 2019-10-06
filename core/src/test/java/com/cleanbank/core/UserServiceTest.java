package com.cleanbank.core;

import com.cleanbank.core.createuser.*;
import com.cleanbank.entities.UserEntity;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        UserRepository userRepository = new UserRepositoryStub();
        UserPresenter presenter = new UserPresenterStub();

        userService = new UserServiceImpl(userRepository, presenter);
    }

    @Test
    public void createUser() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setId(1L);

        UserPresenter presenter = userService.createUser(userRequest);
        presenter.showCreatedUser();
    }

    private static class UserRepositoryStub implements UserRepository {
        @Override
        public UserEntity findUserById(long id) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("userName");
            return userEntity;
        }
    }

    private static class UserPresenterStub implements UserPresenter {
        @Override
        public void showCreatedUser() {
            System.out.println("userName");
        }

        @Override
        public void fillViewModel(CreateUserResponse response) {

        }
    }
}
