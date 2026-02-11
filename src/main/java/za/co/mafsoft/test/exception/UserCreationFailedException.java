package za.co.mafsoft.test.exception;

public class UserCreationFailedException extends RuntimeException{
    public UserCreationFailedException(String message) {
        super(message);
    }
}
