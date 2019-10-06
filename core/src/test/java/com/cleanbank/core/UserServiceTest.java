package com.cleanbank.core;

import com.cleanbank.core.createuser.*;
import com.cleanbank.entities.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

        assertEquals("userName", presenter.getViewModel().getUserName());
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

        private UserViewModel userViewModel;

        @Override
        public void showCreatedUser(CreateUserResponse response) {
            System.out.println(userViewModel.getUserName());
        }

        @Override
        public UserViewModel getViewModel() {
            return userViewModel;
        }

        @Override
        public void fillViewModel(CreateUserResponse response) {
            userViewModel = new UserViewModel();
            userViewModel.setUserName(response.getUserName());
        }
    }
}
