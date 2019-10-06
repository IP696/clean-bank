package com.cleanbank.console;

import com.cleanbank.core.createuser.UserServiceImpl;
import com.cleanbank.entities.UserEntity;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start console...");
        UserController userController= new UserController(new UserServiceImpl(id -> {
            UserEntity userEntity = new UserEntity();
            userEntity.setName("Pavel");
            return userEntity;
        }, new ConsoleUserPresenter()));

        userController.createUser();
    }
}
