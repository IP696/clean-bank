package com.cleanbank.console;

import com.cleanbank.core.createuser.CreateUserResponse;
import com.cleanbank.core.createuser.UserPresenter;

public class ConsoleUserPresenter implements UserPresenter {

    private UserViewModel userViewModel;

    @Override
    public void showCreatedUser() {
        System.out.println(userViewModel.getUserName());
    }

    @Override
    public void fillViewModel(CreateUserResponse response) {
        userViewModel = new UserViewModel();
        userViewModel.setUserName(response.getUserName());
    }
}
