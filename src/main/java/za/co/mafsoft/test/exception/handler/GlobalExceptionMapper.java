package za.co.mafsoft.test.exception.handler;

import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import za.co.mafsoft.test.exception.UserCreationFailedException;
import za.co.mafsoft.test.exception.UserNotFoundException;

import static jakarta.ws.rs.core.Response.Status;
import static jakarta.ws.rs.core.Response.status;

@Slf4j
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof UserNotFoundException) {
            return status(Status.NOT_FOUND)
                    .entity(new ErrorResponse(HttpResponseStatus.NOT_FOUND.code(),
                            exception.getMessage()))
                    .build();
        } else if (exception instanceof UserCreationFailedException) {
            return status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse(HttpResponseStatus.INTERNAL_SERVER_ERROR.code(),
                            exception.getMessage()))
                    .build();
        } else {
            Throwable root = exception.getCause();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse(HttpResponseStatus.INTERNAL_SERVER_ERROR.code(),
                            root != null ? root.getMessage() : exception.getMessage()))
                    .build();
        }
    }
}
