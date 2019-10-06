package com.cleanbank.console;

import com.cleanbank.core.createuser.CreateUserRequest;
import com.cleanbank.core.createuser.UserPresenter;
import com.cleanbank.core.createuser.UserService;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        UserPresenter userPresenter = userService.createUser(createUserRequest);
        userPresenter.showCreatedUser();
    }
}
