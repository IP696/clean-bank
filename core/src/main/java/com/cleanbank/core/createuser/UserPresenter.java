package com.cleanbank.core.createuser;

public interface UserPresenter {
    void showCreatedUser(CreateUserResponse response);

    UserViewModel getViewModel();

    void fillViewModel(CreateUserResponse response);
}
