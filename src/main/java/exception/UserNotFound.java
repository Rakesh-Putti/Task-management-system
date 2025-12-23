package exception;



public class UserNotFound extends RuntimeException {
    private String message = "User not found in the database";

    @Override
    public String getMessage() {
        return message;
    }
}

