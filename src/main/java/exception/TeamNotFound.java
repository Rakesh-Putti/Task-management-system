package exception;



public class TeamNotFound extends RuntimeException {
    private String message = "Team not found in the database";

    @Override
    public String getMessage() {
        return message;
    }
}
