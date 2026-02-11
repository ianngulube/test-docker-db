package za.co.mafsoft.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import za.co.mafsoft.test.entity.User;
import za.co.mafsoft.test.model.UserRequest;
import za.co.mafsoft.test.model.UserResponse;

@Mapper(componentModel = "cdi")
public interface UserRequestMapper {
    @Mapping(source = "email", target = "userId")
    User toUserEntity(final UserRequest request);

    @Mapping(source = "userId", target = "email")
    UserResponse toUserResponse(final User user);
}
