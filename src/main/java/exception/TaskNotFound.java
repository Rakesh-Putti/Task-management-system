package exception;



public class TaskNotFound extends RuntimeException {
    private String message = "Task not found in the database";

    @Override
    public String getMessage() {
        return message;
    }
}
