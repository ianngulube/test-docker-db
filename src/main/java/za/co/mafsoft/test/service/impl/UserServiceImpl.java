package za.co.mafsoft.test.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import za.co.mafsoft.test.UserRepository;
import za.co.mafsoft.test.entity.User;
import za.co.mafsoft.test.exception.UserCreationFailedException;
import za.co.mafsoft.test.exception.UserNotFoundException;
import za.co.mafsoft.test.mapper.UserRequestMapper;
import za.co.mafsoft.test.model.GetUserRequest;
import za.co.mafsoft.test.model.UserCreateResponse;
import za.co.mafsoft.test.model.UserRequest;
import za.co.mafsoft.test.model.UserResponse;
import za.co.mafsoft.test.service.UserService;

import java.util.Optional;

@ApplicationScoped
@Named("userService")
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;
    @Inject
    UserRequestMapper userRequestMapper;

    @Override
    @Transactional
    public UserCreateResponse createUser(UserRequest request) throws UserCreationFailedException {
        Optional<User> user = userRepository.find("userId = ?1", request.email()).singleResultOptional();
        if(user.isPresent()){
            throw new UserCreationFailedException("User already exists");
        }
        userRepository.persist(userRequestMapper.toUserEntity(request));
        return UserCreateResponse.builder()
                .description(String.format("User with userId %s was created successfully", request.email()))
                .email(request.email())
                .build();
    }

    @Override
    public UserResponse getUser(GetUserRequest request) throws UserNotFoundException {
        var userOptional = userRepository.find("userId = ?1", request.email()).singleResultOptional();
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User is not found");
        }
        return userRequestMapper.toUserResponse(userOptional.get());
    }
}
