package com.cleanbank.core.createuser;

import com.cleanbank.entities.UserEntity;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
       UserEntity userEntity = userRepository.findUserById(userRequest.getId());
        CreateUserResponse response = new CreateUserResponse();
        response.setUserName(userEntity.getName());
        return response;
    }
}
