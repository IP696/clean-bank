package com.cleanbank.core.createuser;

import com.cleanbank.entities.UserEntity;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private UserPresenter presenter;

    public UserServiceImpl(UserRepository userRepository, UserPresenter presenter) {
        this.userRepository = userRepository;
        this.presenter = presenter;
    }

    @Override
    public UserPresenter createUser(CreateUserRequest userRequest) {
        UserEntity userEntity = userRepository.findUserById(userRequest.getId());
        CreateUserResponse response = new CreateUserResponse();
        response.setUserName(userEntity.getName());
        presenter.fillViewModel(response);
        return presenter;
    }
}
