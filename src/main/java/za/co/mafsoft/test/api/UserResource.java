package za.co.mafsoft.test.api;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import za.co.mafsoft.test.model.GetUserRequest;
import za.co.mafsoft.test.model.UserRequest;
import za.co.mafsoft.test.service.UserService;

@Path("/user-api")
public class UserResource {
    @Named("userService")
    private final UserService userService;

    @Inject
    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @POST
    @Path("/create-user")
    public Response createUser(final @Valid UserRequest userRequest) {
        var createResponse = userService.createUser(userRequest);
        return Response.ok(createResponse).build();
    }

    @POST
    @Path("/get-user")
    public Response getUser(final @Valid GetUserRequest userRequest) {
        var user = userService.getUser(userRequest);
        return Response.ok(user).build();
    }
}
