package za.co.mafsoft.test.service;

import za.co.mafsoft.test.exception.UserCreationFailedException;
import za.co.mafsoft.test.exception.UserNotFoundException;
import za.co.mafsoft.test.model.GetUserRequest;
import za.co.mafsoft.test.model.UserCreateResponse;
import za.co.mafsoft.test.model.UserRequest;
import za.co.mafsoft.test.model.UserResponse;

public interface UserService {
    UserCreateResponse createUser(UserRequest request) throws UserCreationFailedException;

    UserResponse getUser(GetUserRequest request) throws UserNotFoundException;
}
